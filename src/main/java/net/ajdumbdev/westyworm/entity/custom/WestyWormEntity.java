package net.ajdumbdev.westyworm.entity.custom;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.NavigationConditions;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.MobNavigation;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.IllagerEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.VindicatorEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.tick.Tick;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.function.Predicate;

public class WestyWormEntity extends HostileEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    private int IdleAnimationTimeout = 0;
    static final Predicate<Difficulty> DIFFICULTY_ALLOWS_DOOR_BREAKING_PREDICATE = difficulty -> difficulty == Difficulty.EASY || difficulty == Difficulty.NORMAL || difficulty == Difficulty.HARD ;
    private final BreakDoorGoal breakDoorsGoal = new BreakDoorGoal(this, DIFFICULTY_ALLOWS_DOOR_BREAKING_PREDICATE);
    private boolean canBreakDoors;

    public WestyWormEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.setPathfindingPenalty(PathNodeType.UNPASSABLE_RAIL, 0.0F);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));

        this.goalSelector.add(1, new MeleeAttackGoal(this,1.0,false));
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, false));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, VillagerEntity.class, false ));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, IronGolemEntity.class, true ));
        this.goalSelector.add(3, new WanderAroundFarGoal(this,1.00));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class,10.0F));
        this.goalSelector.add(5, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH,20.0f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,0.35)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,5.0f)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE,50)
                .add(EntityAttributes.GENERIC_STEP_HEIGHT,1);

    }

    private void setupAnimationStates() {
        if (this.IdleAnimationTimeout <= 0) {
            this.IdleAnimationTimeout = 60;
            this.idleAnimationState.start(this.age);
        } else {
            --this.IdleAnimationTimeout;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            this.setupAnimationStates();
        }
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        ItemStack milk = new ItemStack(Items.MILK_BUCKET, 1);
        ItemEntity itemEntity = new ItemEntity(
                this.getWorld(),
                this.getX(),
                this.getY(),
                this.getZ(),
                milk
        );
        itemEntity.setCustomName(Text.literal("Rollout's Milk"));
        itemEntity.setCustomNameVisible(true);
        this.getWorld().spawnEntity(itemEntity);
        super.onDeath(damageSource);
    }

    @Override
    public boolean tryAttack(Entity target) {
        if (super.tryAttack(target)) {
            if (target instanceof LivingEntity) {
                ((LivingEntity)target).addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 100, 1), this);
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public @Nullable EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData) {
        float randomScale = 0.25f + this.random.nextFloat() * 0.75f;
        EntityAttributeInstance scaleAttribute = this.getAttributeInstance(EntityAttributes.GENERIC_SCALE);
        EntityAttributeInstance damageAttribute = this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE);
        EntityAttributeInstance healthAttribute = this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH);
        if (scaleAttribute != null) {
            scaleAttribute.setBaseValue(randomScale);
            damageAttribute.setBaseValue(5.0f*randomScale);
            healthAttribute.setBaseValue(20.0f*randomScale);
        }
        return super.initialize(world, difficulty, spawnReason, entityData);
    }
}
