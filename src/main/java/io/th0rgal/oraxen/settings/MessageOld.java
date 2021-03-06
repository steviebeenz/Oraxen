package io.th0rgal.oraxen.settings;

import io.th0rgal.oraxen.language.LanguageProvider;
import io.th0rgal.oraxen.language.Variable;
import io.th0rgal.oraxen.utils.logs.Logs;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public enum MessageOld {

    CMD_HELP(ChatColor.GREEN, "Check the docs for command usage: https://docs.oraxen.com/usage/commands"),

    UPDATING_CONFIG(ChatColor.RED, "Configuration option \"%s\" not found, adding it!"),
    CONFIGS_VALIDATION_FAILED(ChatColor.RED, "Configurations validation failed, plugin automatically disabled!"),
    NOT_A_PLAYER_ERROR(ChatColor.RED, "You must be a player to use this command!"),
    COMMAND_DOES_NOT_EXIST_ERROR(ChatColor.RED, "This command doesn't exist, check the doc!"),
    REPAIRED_ITEMS(ChatColor.GREEN, "%s item(s) were successfully repaired!"),
    CANNOT_BE_REPAIRED(ChatColor.RED, "The Item \"%s\" cannot be repaired!"),
    CANNOT_BE_REPAIRED_INVALID(ChatColor.RED, "You need to hold an valid Item in your hand!"),
    ZIP_BROWSE_ERROR(ChatColor.RED, "An error occured browsing the zip"),
    DONT_HAVE_PERMISSION(ChatColor.RED, "You need the permission %s to do this"),
    MECHANIC_DOESNT_EXIST(ChatColor.RED, "The mechanic %s doesn't exist"),
    WRONG_TYPE(ChatColor.RED, "You are using an invalid type"),
    BAD_RECIPE(ChatColor.RED, "The recipe \"%s\" is invalid, please ensure all its ingredients exist in your config"),
    ITEM_NOT_FOUND(ChatColor.RED, "Item \"%s\" not found"),
    PLUGIN_HOOKS(ChatColor.GREEN, "Plugin \"%s\" detected, enabling hooks"),
    PLUGIN_UNHOOKS(ChatColor.GREEN, "Unhooking plugin \"%s\""),
    NOT_A_NUMBER(ChatColor.RED, "Input string \"%s\" is not a number"),
    ITEM_GAVE(ChatColor.GREEN, "Successfully gave %s \"%s\" to %s"),
    PLAYER_NOT_FOUND(ChatColor.RED, "Player \"%s\" not found"),
    PLAYER_NOT_GIVEN(ChatColor.RED, "You must specify a player"),

    UNCONSISTENT_CONFIG_VERSION(ChatColor.RED, "Config updating error: does this config come from the future?"),
    CONFIGS_NOT_UPDATED(ChatColor.GREEN, "Configs version number is consistent: skipping updating"),
    CONFIGS_UPDATING_FAILED(ChatColor.RED, "Configs updating failed, please post an issue on github"),

    RELOAD(ChatColor.GREEN, "%s successfully reloaded"),
    REGENERATED(ChatColor.GREEN, "%s successfully regenerated"),
    SAVE_RECIPE(ChatColor.GREEN, "You sucessfully saved the recipe \"%s\". Restart the server to enable new crafts."),

    NOT_ENOUGH_EXP(ChatColor.GREEN, "You need more experience to do this"),
    DELAY(ChatColor.GREEN, "Wait another %s");

    private final String message;

    MessageOld(ChatColor color, String message) {
        this(color + message);
    }

    MessageOld(String message) {
        this.message = ' ' + message;
    }

    @Override
    public String toString() {
        return Variable.PREFIX.translate(LanguageProvider.DEFAULT_LANGUAGE) + message;
    }

    public void send(CommandSender sender) {
        sender.sendMessage(toString());
    }

    public void send(CommandSender sender, String... arguments) {
        // the cast is here to indicates to compiler a non-varargs call
        sender.sendMessage(String.format(toString(), (Object[]) arguments));
    }

    public void log(String... arguments) {
        Logs.log(String.format(message, (Object[]) arguments));
    }

    public void log() {
        Logs.log(message);
    }

    public void logWarning(String... arguments) {
        Logs.logWarning(String.format(toString(), (Object[]) arguments));
    }

    public void logWarning() {
        Logs.logWarning(toString());
    }

    public void logError(String... arguments) {
        Logs.logError(String.format(toString(), (Object[]) arguments));
    }

    public void logError() {
        Logs.logError(toString());
    }

}
