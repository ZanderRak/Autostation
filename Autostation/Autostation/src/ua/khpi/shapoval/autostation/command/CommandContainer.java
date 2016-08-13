/**
 * 
 */
package ua.khpi.shapoval.autostation.command;

import java.util.Map;
import java.util.TreeMap;
import org.apache.log4j.Logger;

/**
 * @author serg_shapoval
 *
 */
public class CommandContainer {
	private static final Logger LOG = Logger.getLogger(CommandContainer.class);
	private Map<String, Command> commands = new TreeMap<String, Command>();

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
	public Command get(String commandName) {
		if (commandName == null || !commands.containsKey(commandName)) {
			LOG.trace("Command not found, name --> " + commandName);
			return this.commands.get("noCommand");
		}
		return this.commands.get(commandName);
	}

}
