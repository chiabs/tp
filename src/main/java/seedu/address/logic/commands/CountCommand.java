package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public class CountCommand extends Command {
    public static final String COMMAND_WORD = "count";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows total number of people recorded."
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_NOT_IMPLEMENTED_YET = "Remark command not implemented yet";


    @Override
    public CommandResult execute(Model model) throws CommandException {
        return new CommandResult("There are "
                + String.valueOf(model.count()) + " records.");
    }
}
