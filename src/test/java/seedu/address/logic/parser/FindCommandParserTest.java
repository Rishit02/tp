package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.FIND_AMY;
import static seedu.address.logic.commands.CommandTestUtil.FIND_BOB;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NOK;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.UpdateCommand;
import seedu.address.model.person.AddressContainsKeywordsPredicate;
import seedu.address.model.person.DescriptionContainsKeywordsPredicate;
import seedu.address.model.person.EmailContainsKeywordsPredicate;
import seedu.address.model.person.KinContainsKeywordsPredicate;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.PhoneContainsKeywordsPredicate;
import seedu.address.model.person.TagContainsKeywordsPredicate;

import java.util.List;


public class FindCommandParserTest {

    private FindCommandParser parser = new FindCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validValue_success() {
        ArgumentMultimap argMultimap1 = ArgumentTokenizer.tokenize(FIND_AMY, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL,
                PREFIX_ADDRESS, PREFIX_NOK, PREFIX_DESCRIPTION, PREFIX_TAG);
        List<String> nameKeywords1 = argMultimap1.getAllValues(PREFIX_NAME);
        List<String> phoneKeywords1 = argMultimap1.getAllValues(PREFIX_PHONE);
        List<String> emailKeywords1 = argMultimap1.getAllValues(PREFIX_EMAIL);
        List<String> addressKeywords1 = argMultimap1.getAllValues(PREFIX_ADDRESS);
        List<String> kinKeywords1 = argMultimap1.getAllValues(PREFIX_NOK);
        List<String> tagKeywords1 = argMultimap1.getAllValues(PREFIX_TAG);
        List<String> descriptionKeywords1 = argMultimap1.getAllValues(PREFIX_DESCRIPTION);
        FindCommand expectedCommand1 = new FindCommand(new NameContainsKeywordsPredicate(nameKeywords1),
                new PhoneContainsKeywordsPredicate(phoneKeywords1),
                new AddressContainsKeywordsPredicate(addressKeywords1),
                new EmailContainsKeywordsPredicate(emailKeywords1),
                new TagContainsKeywordsPredicate(tagKeywords1),
                new KinContainsKeywordsPredicate(kinKeywords1),
                new DescriptionContainsKeywordsPredicate(descriptionKeywords1));

        assertParseSuccess(parser, FIND_AMY, expectedCommand1);

        ArgumentMultimap argMultimap2 = ArgumentTokenizer.tokenize(FIND_BOB, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL,
                PREFIX_ADDRESS, PREFIX_NOK, PREFIX_DESCRIPTION, PREFIX_TAG);
        List<String> nameKeywords2 = argMultimap2.getAllValues(PREFIX_NAME);
        List<String> phoneKeywords2 = argMultimap2.getAllValues(PREFIX_PHONE);
        List<String> emailKeywords2 = argMultimap2.getAllValues(PREFIX_EMAIL);
        List<String> addressKeywords2 = argMultimap2.getAllValues(PREFIX_ADDRESS);
        List<String> kinKeywords2 = argMultimap2.getAllValues(PREFIX_NOK);
        List<String> tagKeywords2 = argMultimap2.getAllValues(PREFIX_TAG);
        List<String> descriptionKeywords2 = argMultimap2.getAllValues(PREFIX_DESCRIPTION);
        FindCommand expectedCommand2 = new FindCommand(new NameContainsKeywordsPredicate(nameKeywords2),
                new PhoneContainsKeywordsPredicate(phoneKeywords2),
                new AddressContainsKeywordsPredicate(addressKeywords2),
                new EmailContainsKeywordsPredicate(emailKeywords2),
                new TagContainsKeywordsPredicate(tagKeywords2),
                new KinContainsKeywordsPredicate(kinKeywords2),
                new DescriptionContainsKeywordsPredicate(descriptionKeywords2));
        assertParseSuccess(parser, FIND_BOB, expectedCommand2);
    }

}
