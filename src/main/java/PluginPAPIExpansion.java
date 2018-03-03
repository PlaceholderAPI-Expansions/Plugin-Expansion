/*
 *
 *  *
 *  *  * PluginPAPIExpansion - An expansion for the Placeholder API
 *  *  * Copyright (C) 2018 Max Berkelmans AKA LemmoTresto
 *  *  *
 *  *  * This program is free software: you can redistribute it and/or modify
 *  *  * it under the terms of the GNU General Public License as published by
 *  *  * the Free Software Foundation, either version 3 of the License, or
 *  *  * (at your option) any later version.
 *  *  *
 *  *  * This program is distributed in the hope that it will be useful,
 *  *  * but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  *  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  *  * GNU General Public License for more details.
 *  *  *
 *  *  * You should have received a copy of the GNU General Public License
 *  *  * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *  *
 *
 */

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class PluginPAPIExpansion extends PlaceholderExpansion {


    /**
     * We do not use any third party plugins so we can return true.
     * @return true
     */
    @Override
    public boolean canRegister() {
        return true;
    }

    /**
     * @return LemmoTresto which is the name of the author.
     */
    @Override
    public String getAuthor() {
        return "LemmoTresto";
    }

    /**
     * @return String identifier 'plugin'
     */
    @Override
    public String getIdentifier() {
        return "plugin";
    }

    /**
     * @return null as we do not have a third party plugin.
     */
    @Override
    public String getPlugin() {
        return null;
    }

    /**
     * @return version of our expansion 1.0.0
     */
    @Override
    public String getVersion() {
        return "1.1.0";
    }

    /**
     * This method gets called when we need to parse a placeholder.
     * @return String parsed boolean
     */
    @Override
    public String onPlaceholderRequest(Player p, String identifier) {

        //Checking if the plugin is enabled.
        if (identifier.toLowerCase().startsWith("isenabled_")) {
            Plugin pl = Bukkit.getPluginManager().getPlugin(identifier.toLowerCase().replace("isenabled_", ""));
            if (pl == null) return "false";
            if (pl.isEnabled()) return "true";
            return "false";
        }

        //Check if plugin is disabled.
        if (identifier.toLowerCase().startsWith("isdisabled_")) {
            Plugin pl = Bukkit.getPluginManager().getPlugin(identifier.toLowerCase().replace("isdisabled_", ""));
            if (pl == null) return "false";
            if (pl.isEnabled()) return "false";
            return "true";
        }

        //Check if a plugin exists in the plugins folder.
        if (identifier.toLowerCase().startsWith("exists_")) {
            Plugin pl = Bukkit.getPluginManager().getPlugin(identifier.toLowerCase().replace("exists_", ""));
            if (pl == null) return "false";
            return "true";
        }

        return null;
    }
}
