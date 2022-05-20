package com.iridium.iridiumcore;

import com.iridium.iridiumcore.multiversion.MultiVersion;
import com.iridium.iridiumcore.multiversion.MultiVersion_V1_12_R1;
import com.iridium.iridiumcore.nms.NMS;
import com.iridium.iridiumcore.nms.NMS_V1_12_R1;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

@SuppressWarnings("Convert2MethodRef")
public enum MinecraftVersion {

    /**
     * IntelliJ will recommend you to replace these with method reference.
     * However, this would break the plugins on some machines running the HotSpot VM.
     * Just leave this as it is and add new versions down below in the same way.
     */
    V1_12_R1(() -> new NMS_V1_12_R1(), MultiVersion_V1_12_R1::new);

    private final Supplier<NMS> nmsSupplier;
    private final JavaPluginSupplier<MultiVersion> multiVersionSupplier;

    MinecraftVersion(Supplier<NMS> nmsSupplier, JavaPluginSupplier<MultiVersion> multiVersionSupplier) {
        this.nmsSupplier = nmsSupplier;
        this.multiVersionSupplier = multiVersionSupplier;
    }

    public NMS getNms() {
        return nmsSupplier.get();
    }

    public MultiVersion getMultiVersion(JavaPlugin javaPlugin) {
        return multiVersionSupplier.get(javaPlugin);
    }

    @NotNull
    public static MinecraftVersion byName(String version) {
        for (MinecraftVersion minecraftVersion : values()) {
            if (minecraftVersion.name().equalsIgnoreCase(version)) {
                return minecraftVersion;
            }
        }

        return null;
    }

}
