// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelcustom_model<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "custom_model"), "main");
	private final ModelPart bb_main;

	public Modelcustom_model(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main",
				CubeListBuilder.create().texOffs(50, 59)
						.addBox(15.0F, -15.0F, -24.0F, 1.0F, 10.0F, 48.0F, new CubeDeformation(0.0F)).texOffs(0, 49)
						.addBox(-16.0F, -15.0F, -24.0F, 1.0F, 10.0F, 48.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-10.0F, -12.0F, -25.0F, 20.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(50, 54)
						.addBox(-15.0F, -20.0F, -9.0F, 30.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).texOffs(112, 0)
						.addBox(-15.0F, -15.0F, -24.0F, 30.0F, 10.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(38, 21)
						.addBox(-13.0F, -12.0F, -25.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(38, 18)
						.addBox(13.0F, -12.0F, -25.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(7, 37)
						.addBox(-15.0F, -12.0F, -25.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(28, 16)
						.addBox(11.0F, -12.0F, -25.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 49)
						.addBox(-15.0F, -4.0F, -21.0F, 5.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 49)
						.addBox(-15.0F, -4.0F, 13.0F, 5.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 49)
						.addBox(10.0F, -4.0F, 13.0F, 5.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 49)
						.addBox(10.0F, -4.0F, -21.0F, 5.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 29)
						.addBox(-17.0F, -11.0F, 10.0F, 1.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(0, 61)
						.addBox(-18.0F, -8.0F, -24.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(100, 69)
						.addBox(-15.0F, -15.0F, 8.0F, 30.0F, 10.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-16.0F, -5.0F, -24.0F, 32.0F, 1.0F, 48.0F, new CubeDeformation(0.0F)).texOffs(38, 13)
						.addBox(-10.0F, -5.0F, 22.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 37)
						.addBox(8.0F, -5.0F, 22.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(100, 95)
						.addBox(-18.0F, -8.0F, -26.0F, 36.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(50, 59)
						.addBox(16.0F, -8.0F, -24.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(100, 49)
						.addBox(-15.0F, -21.0F, -9.0F, 30.0F, 1.0F, 19.0F, new CubeDeformation(0.0F)).texOffs(0, 5)
						.addBox(-15.0F, -20.0F, -9.0F, 0.0F, 5.0F, 19.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(15.0F, -20.0F, -9.0F, 0.0F, 5.0F, 19.0F, new CubeDeformation(0.0F)).texOffs(23, 41)
						.addBox(-3.0F, -17.0F, 14.0F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(-2.0F, -25.0F, 15.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(33, 4)
						.addBox(8.0F, -19.0F, 23.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 29)
						.addBox(-11.0F, -19.0F, 23.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(36, 49)
						.addBox(8.0F, -18.0F, 20.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(33, 29)
						.addBox(-11.0F, -18.0F, 20.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(15, 29)
						.addBox(-17.0F, -15.0F, 10.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(15, 4)
						.addBox(16.0F, -15.0F, 10.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 4)
						.addBox(16.0F, -11.0F, 10.0F, 1.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = bb_main
				.addOrReplaceChild("cube_r1",
						CubeListBuilder.create().texOffs(50, 19).addBox(10.0F, -20.0F, -15.0F, 0.0F, 5.0F, 30.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}