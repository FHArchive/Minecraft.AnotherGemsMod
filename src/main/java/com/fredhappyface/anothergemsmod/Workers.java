package com.fredhappyface.anothergemsmod;

import com.fredhappyface.anothergemsmod.init.ModBlocks;
import com.fredhappyface.anothergemsmod.init.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


/**
 * Workers allows client and server code to be separated, while executing common code on both
 * sides. You could use this just for the sided code, but I initialize everything in proxy classes.
 * There are two nested classes, {@link Client} and {@link Server}.
 */
class Workers {
    Workers() {
        // Register the setup, enqueueIMC, and processIMC methods for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(Workers::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(Workers::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(Workers::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModBlocks::registerAll);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModItems::registerAll);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private static void commonSetup(FMLCommonSetupEvent event) {
    }

    private static void enqueueIMC(final InterModEnqueueEvent event) {
    }

    private static void processIMC(final InterModProcessEvent event) {
    }

    @SubscribeEvent
    public void serverStarting(FMLServerStartingEvent event) {
    }

    /*
    Client only
     */
    static class Client extends Workers {
        Client() {
            FMLJavaModLoadingContext.get().getModEventBus().addListener(Client::clientSetup);
        }

        private static void clientSetup(FMLClientSetupEvent event) {
        }
    }

    /*
    Server only
     */
    static class Server extends Workers {
        Server() {
            FMLJavaModLoadingContext.get().getModEventBus().addListener(Server::serverSetup);
        }

        private static void serverSetup(FMLDedicatedServerSetupEvent event) {
        }
    }
}