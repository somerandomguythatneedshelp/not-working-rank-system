package stuff.main;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class RankManager {

    private Main main;

    private File file;
    private YamlConfiguration config;

  public RankManager(Main main) {
      this.main = main;

      if (!main.getDataFolder().exists()) {
          main.getDataFolder().mkdir();
      }

      file = new File(main.getDataFolder(), "ranks.yml");
      if (!file.exists()) {
          try {
              file.createNewFile();
          } catch(IOException e) {
              e.printStackTrace();
          }
      }
      config = YamlConfiguration.loadConfiguration(file);
  }

  public void setRank(UUID uuid, Rank rank) {
      config.set(uuid.toString(), rank.name());
      try {
          config.save(file);
      } catch (IOException e) {
          e.printStackTrace();
      }

      if (Bukkit.getOfflinePlayer(uuid).isOnline()) {
          Player player = Bukkit.getPlayer(uuid);
          main.getNametagManager().removeTag(player);
          main.getNametagManager().newTag(player);
      }

  }

  public Rank getRank(UUID uuid) {
        return Rank.valueOf(config.getString(uuid.toString()));
  }

}
