package com.mikaeel.nickbook.ui;

import com.mikaeel.nickbook.NickBookPlugin;
import com.mikaeel.nickbook.service.NickService;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

public final class NickBook {
    private NickBook() {}
    public static void openRank(NickBookPlugin p, Player player, NickService s) {
        open(player, s.color("&0Let's get you set up with your nickname! First, you'll need to choose which &0&lRANK&r&0 you would like to be shown as when nicked.\n\n&0➤ &7DEFAULT\n&0➤ &aVIP\n&0➤ &aVIP&6+\n&0➤ &bMVP\n&0➤ &bMVP&c+\n\n&7Type: /nick rank <rank>"));
    }
    public static void openSkin(NickBookPlugin p, Player player, NickService s) {
        open(player, s.color("&0Awesome! Now, which &0&lSKIN&r&0 would you like to have while nicked?\n\n&0➤ My normal skin\n&0➤ Steve/Alex skin\n&0➤ Random skin\n\n&7Type: /nick skin <normal|alex|random>"));
    }
    public static void openName(NickBookPlugin p, Player player, NickService s) {
        open(player, s.color("&0Alright, now you'll need to choose the &0&lNAME&r&0 to use!\n\n&0➤ Use a random name\n\n&7Type: /nick name random\n\n&0To go back to being your usual self, type:\n&0&l/nick reset"));
    }
    public static void openRandomName(NickBookPlugin p, Player player, NickService s) {
        s.randomName(player);
        open(player, s.color("&0We've generated a random username for you:\n&0&l"+s.candidate(player)+"\n\n&2&lUSE NAME\n&7Type: /nick name previous\n\n&c&lTRY AGAIN\n&7Type: /nick name random"));
    }
    public static void openConfirmation(NickBookPlugin p, Player player, NickService s) {
        open(player, s.color("&0You have finished setting up your nickname!\n\n&0When you go into a game, you will be nicked as "+s.get(player).name()+"&0.\n\n&0You will not be nicked in lobbies.\n\n&0To go back to being your usual self, type:\n&0&l/nick reset"));
    }
    private static void open(Player player, String page) {
        ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta meta = (BookMeta) book.getItemMeta();
        meta.setTitle("Nick Setup");
        meta.setAuthor("NickBook");
        meta.addPage(page);
        book.setItemMeta(meta);
        player.getInventory().addItem(book);
        player.sendMessage("§aNick Setup book added to your inventory. Right-click it to open.");
    }
}
