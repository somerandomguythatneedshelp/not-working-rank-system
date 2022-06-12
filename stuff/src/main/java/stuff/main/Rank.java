package stuff.main;

import org.bukkit.ChatColor;

public enum Rank {

    OWNER(ChatColor.DARK_RED + "[Owner]"),
    ADMIN(ChatColor.RED + "[Admin]"),
    MOD(ChatColor.GREEN + "[Moderator]"),
    BUILDER(ChatColor.DARK_GREEN + "[Builder]"),
    MEMBER(ChatColor.YELLOW + "[Member]"),
    GOD(ChatColor.BLUE + "[GOD]"),
    LEGEND(ChatColor.BLACK + "[Legend]"),
    MVP(ChatColor.BLUE + "[MVP]"),
    MVPP(ChatColor.BLUE + "[MVP+]"),
    VIP(ChatColor.GREEN + "[VIP]"),
    VIPP(ChatColor.GREEN + "[VIP+]"),
    NEWBIE(ChatColor.GRAY + "[Newbie]");


    private String display;





    Rank(String display) {
        this.display = display;
    }
    public String getDisplay() { return display; }


}

