/**
 * 
 */
package ua.khpi.shapoval.autostation.command;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author serg_shapoval
 *
 */

public class CommandContainer {
	private static Map<String, Command> commands = new TreeMap<String, Command>();

	public CommandContainer(Map<String, Command> commands) {
		this.commands = commands;
	}

	/**
	 * Returns command object with the given name.
	 * 
	 * @param commandName
	 *            Name of the command.
	 * @return Command object.
	 */
	public static Command get(String commandName) {
		if (commandName == null || !commands.containsKey(commandName)) {
			return commands.get("noCommand");
		}
		return commands.get(commandName);
	}

}
