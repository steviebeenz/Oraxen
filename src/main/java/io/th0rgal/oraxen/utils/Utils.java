package io.th0rgal.oraxen.utils;

import com.google.gson.JsonObject;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.MultipleFacing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static final LegacyComponentSerializer LEGACY_COMPONENT_SERIALIZER = LegacyComponentSerializer.builder()
            .hexColors()
            .useUnusualXRepeatedCharacterHexFormat()
            .build();

    public static List<String> toLowercaseList(String... values) {
        ArrayList<String> list = new ArrayList<>();
        for (String value : values)
            list.add(value.toLowerCase());
        return list;
    }

    public static String[] toLowercase(String... values) {
        for (int index = 0; index < values.length; index++)
            values[index] = values[index].toLowerCase();
        return values;
    }

    public static long getVersion(String format) {
        return Long.parseLong(OffsetDateTime.now().format(DateTimeFormatter.ofPattern(format)));
    }

    public static int getCode(MultipleFacing blockData) {
        final List<BlockFace> properties = Arrays
                .asList(BlockFace.EAST, BlockFace.WEST, BlockFace.SOUTH, BlockFace.NORTH, BlockFace.DOWN, BlockFace.UP);
        int sum = 0;
        for (BlockFace blockFace : blockData.getFaces())
            sum += (int) Math.pow(2, properties.indexOf(blockFace));
        return sum;
    }

    public static JsonObject getBlockstateWhenFields(int code) {
        JsonObject whenJson = new JsonObject();
        final String[] properties = new String[]{"up", "down", "north", "south", "west", "east"};
        for (int i = 0; i < properties.length; i++)
            whenJson.addProperty(properties[properties.length - 1 - i], (code & 0x1 << i) != 0);
        return whenJson;
    }

    public static void setBlockFacing(MultipleFacing blockData, int code) {
        final BlockFace[] properties = new BlockFace[]{BlockFace.EAST, BlockFace.WEST, BlockFace.SOUTH,
                BlockFace.NORTH, BlockFace.DOWN, BlockFace.UP};
        for (int i = 0; i < properties.length; i++) {
            blockData.setFace(properties[i], (code & 0x1 << i) != 0);
        }
    }

    public static void writeStringToFile(File file, String content) {
        try {
            file.getParentFile().mkdirs();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(content);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final List<Material> REPLACEABLE_BLOCKS = Arrays
            .asList(Material.SNOW, Material.VINE, Material.GRASS, Material.TALL_GRASS, Material.SEAGRASS, Material.FERN,
                    Material.LARGE_FERN);

}