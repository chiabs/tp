package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public class CountCommand extends Command{
    public static final String COMMAND_WORD = "count";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        return new CommandResult("There are "
                + String.valueOf(model.count()) + " records.");
    }
}
