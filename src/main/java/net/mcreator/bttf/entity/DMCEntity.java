
package net.mcreator.bttf.entity;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;
import net.minecraft.core.BlockPos;

import net.mcreator.bttf.init.BttfModEntities;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import net.mcreator.bttf.custom.State;

public class DMCEntity extends PathfinderMob implements IAnimatable {
	private int CURENT_HOVERING_TIME = 0;
	private State state = State.GROUND;
	private AnimationFactory factory = new AnimationFactory(this);
	public DMCEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(BttfModEntities.DMC.get(), world);
	}

	public DMCEntity(EntityType<DMCEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		this.moveControl = new MoveControl(this);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new FlyingPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();

	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
	}

	@Override
	public boolean causeFallDamage(float l, float d, DamageSource source) {
		return false;
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud)
			return false;
		if (source == DamageSource.CACTUS)
			return false;
		if (source == DamageSource.DROWN)
			return false;
		return super.hurt(source, amount);
	}

	@Override
	protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
	}

	@Override
	public void setNoGravity(boolean ignored) {
		super.setNoGravity(ignored);
	}

	public void aiStep() {
		super.aiStep();
		if(state == State.GROUND)
		{
			this.setNoGravity(false);
		}
		else
		{
			this.setNoGravity(true);
		}

	}

	@Override
	public void tick() {
		super.tick();
		if(state == State.ABOUT_TO_HOVER)
		{
			CURENT_HOVERING_TIME++;
			if(CURENT_HOVERING_TIME >= 30)
			{
				state = State.HOVER;
				CURENT_HOVERING_TIME = 0;
			}
		}
		if(state == State.ABOUT_TO_GROUND)
		{
			CURENT_HOVERING_TIME++;
			if(CURENT_HOVERING_TIME >= 30)
			{
				state = State.GROUND;
				CURENT_HOVERING_TIME = 0;
			}
		}
	}

	public void setState(State state) {
		this.state = state;
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.2);
		builder = builder.add(Attributes.MAX_HEALTH, 20);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 255);
		builder = builder.add(Attributes.FLYING_SPEED, 0.2);
		return builder;
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController<>(this,"controller",0,this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
	{
		if(state == State.ABOUT_TO_HOVER)
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.car.hovering", false));
			return PlayState.CONTINUE;
		}
		if(state == State.ABOUT_TO_GROUND)
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.car.grounding", false));
			return PlayState.CONTINUE;
		}
		if(state == State.HOVER)
		{
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.car.hover", true));
			return PlayState.CONTINUE;
		}
		event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.car.ground", true));
		return PlayState.CONTINUE;
	}
	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level.isClientSide());

		super.mobInteract(sourceentity, hand);

		sourceentity.startRiding(this);

		return retval;
	}
	@Override
	public void travel(Vec3 dir) {
		Entity entity = this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
		if (this.isVehicle()) {
			this.setYRot(entity.getYRot());
			this.yRotO = this.getYRot();
			this.setXRot(entity.getXRot() * 0.5F);
			this.setRot(this.getYRot(), this.getXRot());
			this.flyingSpeed = this.getSpeed() * 0.15F;
			this.yBodyRot = entity.getYRot();
			this.yHeadRot = entity.getYRot();
			this.maxUpStep = 1.0F;

			if (entity instanceof LivingEntity passenger) {
				this.setSpeed((float) this.getAttributeValue(Attributes.MOVEMENT_SPEED));

				float forward = passenger.zza;

				float strafe = passenger.xxa;

				super.travel(new Vec3(strafe, 0, forward));
			}

			this.animationSpeedOld = this.animationSpeed;
			double d1 = this.getX() - this.xo;
			double d0 = this.getZ() - this.zo;
			float f1 = (float) Math.sqrt(d1 * d1 + d0 * d0) * 4;
			if (f1 > 1.0F)
				f1 = 1.0F;
			this.animationSpeed += (f1 - this.animationSpeed) * 0.4F;
			this.animationPosition += this.animationSpeed;
			return;
		}
		this.maxUpStep = 0.5F;
		this.flyingSpeed = 0.02F;

		super.travel(dir);
	}

	public State getState() {
		return state;
	}
}
