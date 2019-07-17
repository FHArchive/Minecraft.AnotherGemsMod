package com.fredhappyface.anothergemsmod;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;
import java.util.Optional;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Main.MOD_ID)
public class Main
{

    public static final String MOD_ID = "anothergemsmod";



    public static final Logger LOGGER = LogManager.getLogger();



    public Main() {
        // Create proxy instance. DistExecutor.runForDist also returns the created object, so you
        // could store that in a variable if you need it.
        // We cannot use method references here because it could load classes on invalid sides.
        //noinspection Convert2MethodRef
        DistExecutor.runForDist(
                () -> () -> new Workers.Client(),
                () -> () -> new Workers.Server()
        );
    }


    @Nonnull
    public static String getVersion() {
        Optional<? extends ModContainer> o = ModList.get().getModContainerById(MOD_ID);
        if (o.isPresent()) {
            return o.get().getModInfo().getVersion().toString();
        }
        return "NONE";
    }


    /*
    Assumes dev if getVersion is none
     */
    public static boolean isDevBuild() {
        String version = getVersion();
        return "NONE".equals(version);
    }


    @Nonnull
    public static ResourceLocation getId(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}