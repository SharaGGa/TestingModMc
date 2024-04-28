package org.nero.justtest;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraft.sounds.SoundSource;

import java.util.Timer;
import java.util.TimerTask;
import java.util.HashSet;
import java.util.Set;

@Mod(TestModMc.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TestModMc
{



//    private final Set<Entity> deadEntities = new HashSet<>();
//    @SubscribeEvent
//    public void livingDeath(LivingDeathEvent event) {
//        if (deadEntities.add(event.getEntityLiving())) {
//            // Получение координат моба
//            double x = event.getEntityLiving().getX();
//            double y = event.getEntityLiving().getY();
//            double z = event.getEntityLiving().getZ();
//            Level world = event.getEntityLiving().level;
//
//            Timer timer = new Timer();
//            timer.schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    world.playSound(null, x, y, z, Sound.POOF.get(), SoundSource.HOSTILE, 1.0f, 1.0f);
//                }
//            }, 1000);
//        }
//
//    }
//



    public static final String MOD_ID = "justtest";


    public TestModMc()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        Sound.register(modEventBus);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        MinecraftForge.EVENT_BUS.register(this);
    }


    private void setup(final FMLCommonSetupEvent event)
    {

    }


}
