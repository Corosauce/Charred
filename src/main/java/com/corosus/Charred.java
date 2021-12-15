package com.corosus;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Charred.MODID)
public class Charred
{
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String MODID = "charred";

    public Charred() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        CharredRegistry.BLOCKS.register(bus);
        CharredRegistry.ITEMS.register(bus);
    }
}
