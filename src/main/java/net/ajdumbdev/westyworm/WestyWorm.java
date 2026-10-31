package net.ajdumbdev.westyworm;

import net.ajdumbdev.westyworm.entity.ModEntities;
import net.ajdumbdev.westyworm.entity.custom.WestyWormEntity;
import net.ajdumbdev.westyworm.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.entity.event.v1.EntitySleepEvents;
import net.fabricmc.fabric.api.message.v1.ServerMessageEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

import net.minecraft.util.math.random.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WestyWorm implements ModInitializer {
	public static final String MOD_ID = "westy-worm";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItems.registerModItems();

		FabricDefaultAttributeRegistry.register(ModEntities.WESTY_WORM, WestyWormEntity.createAttributes());

		EntitySleepEvents.STOP_SLEEPING.register((entity, sleepingPos) -> {
			if (!entity.getWorld().isClient() && entity instanceof net.minecraft.server.network.ServerPlayerEntity player) {
				ServerWorld serverWorld = (ServerWorld) player.getWorld();

				Random random = serverWorld.getRandom();
				if (random.nextInt(100) <= 10) {
					WestyWormEntity worm = ((EntityType<WestyWormEntity>) EntityType.get("westy-worm:westy_worm").get()).create(serverWorld);
					if (worm != null) {
						worm.refreshPositionAndAngles(player.getX(), player.getY(), player.getZ(), 0.0f, 0.0f);
						serverWorld.spawnEntity(worm);
						float randomScale = 0.25f + random.nextFloat() * 0.5f;
						EntityAttributeInstance scaleAttribute = worm.getAttributeInstance(EntityAttributes.GENERIC_SCALE);
						if (scaleAttribute != null) {
							scaleAttribute.setBaseValue(randomScale);
						}
					}
				}
			}
		});

		LOGGER.info("Hello Fabric world!");
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
