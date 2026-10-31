package net.ajdumbdev.westyworm.entity;

import net.ajdumbdev.westyworm.WestyWorm;
import net.ajdumbdev.westyworm.entity.custom.WestyWormEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<WestyWormEntity> WESTY_WORM = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(WestyWorm.MOD_ID,"westy_worm"),
            EntityType.Builder.create(WestyWormEntity::new, SpawnGroup.CREATURE)
                    .dimensions(1f,1f).build());

    public static void registerModEntities() {
        WestyWorm.LOGGER.info("Regis Mod Entities");
    }
}
