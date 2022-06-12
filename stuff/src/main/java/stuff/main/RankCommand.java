package stuff.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RankCommand implements CommandExecutor {

    private Main main;

    public RankCommand(Main main) {
        this.main = main;

    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
            if(commandSender instanceof Player) {
                Player player = (Player) commandSender;

                if (player.isOp()) {
                    if (args.length == 2) {
                        if (Bukkit.getOfflinePlayer(args[0]) != null) {
                            OfflinePlayer tar = Bukkit.getOfflinePlayer(args[0]);

                            for (Rank rank : Rank.values()) {
                                if (rank.name().equalsIgnoreCase(args[1])) {
                                    main.getRankManager().setRank(tar.getUniqueId(), rank);

                                    player.sendMessage(ChatColor.GREEN + "You Changed " + tar.getName() + "'s rank to " + rank.getDisplay() + ChatColor.GREEN + "");
                                    if (tar.isOnline()) {
                                        tar.getPlayer().sendMessage(ChatColor.GREEN + "Your rank has been changed to " + rank.getDisplay() + ChatColor.GREEN + ".");
                                    }
                                    return false;
                                }
                            }

                                player.sendMessage(ChatColor.RED + "You did not Specify a valid rank!");
                        } else {
                            player.sendMessage(ChatColor.RED + "This Player has never joined the server before!");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "Invalid usage! Please use /rank <player> <rank>");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "You must be Oped to use that Command!");
                }
            }
        return false;
    }
}
