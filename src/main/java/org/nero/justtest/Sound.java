package org.nero.justtest;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.lwjgl.system.CallbackI;

public class Sound {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TestModMc.MOD_ID);

    public static final RegistryObject<SoundEvent> POOF = registerSoundEvent("poof");
    public static final RegistryObject<SoundEvent> RECIPE_NOTIFY = registerSoundEvent("recipe_notify");
    public static final RegistryObject<SoundEvent> ADV_NOTIFY = registerSoundEvent("adv_notify");
    public static final RegistryObject<SoundEvent> GOAL_NOTIFY = registerSoundEvent("goal_notify");
    public static final RegistryObject<SoundEvent> TUTOR_NOTIFY = registerSoundEvent("tutor_notify");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(TestModMc.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}