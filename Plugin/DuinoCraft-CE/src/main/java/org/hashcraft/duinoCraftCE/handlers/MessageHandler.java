package org.hashcraft.duinoCraftCE.handlers;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;
import org.hashcraft.duinoCraftCE.DuinoCraftCE;
import org.jetbrains.annotations.Nullable;
import static org.bukkit.Bukkit.getLogger;
import static org.bukkit.Bukkit.getServer;


public class MessageHandler implements Listener {
    private final DuinoCraftCE main;
    public MessageHandler (DuinoCraftCE main){
        this.main = main;
    }
    /*
    * formatCode is a 5 bit number which is decoded into binary for text formatting flags.
    * 00000 - no modification
    * 00001 - italic
    * 00010 - underline
    * 00100 - strikethrough
    * 01000 - bold
    * 10000 - obfuscated
    * */
    public String txtFormat (int num){
        String flags = Integer.toBinaryString(num), code = "";
        StringBuilder sb = new StringBuilder();
        while (sb.length() + flags.length() < 5) {
            sb.append('0');
        }
        sb.append(flags);
        String formattedFlags = sb.toString();
        for (int i = 0; i <= 4; i++){
            if (formattedFlags.charAt(i) == '1'){
                code = code.concat("§" + (char)(107 + i));
            }
        }
        return code;
    }
    public void out (Player p, String msg, long ticks, int mode, String hexColor, int formatCode) {
        new BukkitRunnable() {
            @Override
            public void run() {
                switch (mode){
                    case 0:
                        getServer().dispatchCommand(getServer().getConsoleSender(), msg);
                        getLogger().info("A console command was executed for " + p.getName());
                        break;
                    case 1:
                        @Nullable Component cMsg = Component.text(txtFormat(formatCode).concat(msg)).color(TextColor.fromHexString(hexColor));
                        p.sendMessage(cMsg);
                        getLogger().info("A message was sent to " + p.getName());
                        break;
                }
            }
        }.runTaskLater(main, ticks);
    }
}
