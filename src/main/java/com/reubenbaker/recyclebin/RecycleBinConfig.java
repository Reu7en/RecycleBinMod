package com.reubenbaker.recyclebin;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class RecycleBinConfig {
    public static ForgeConfigSpec COMMON_SPEC;
    public static CommonConfig COMMON_CONFIG;

    static {
        Pair<CommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder()
            .configure(CommonConfig::new);

        COMMON_CONFIG = specPair.getLeft();
        COMMON_SPEC = specPair.getRight();
    }

    public static class CommonConfig {
        public final ForgeConfigSpec.ConfigValue<String> recycleKey;
        public final ForgeConfigSpec.IntValue maxItemsInBin;

        public CommonConfig(ForgeConfigSpec.Builder builder) {
            builder.comment("Recycle Bin Mod Configuration");
            recycleKey = builder
                    .comment("Key to recycle items")
                    .define("recycleKey", "r");
            maxItemsInBin = builder
                    .comment("Maximum number of items allowed in the recycle bin (1-27)")
                    .defineInRange("maxItemsInBin", 9, 1, 27);
        }
    }
}
