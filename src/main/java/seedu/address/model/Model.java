package seedu.address.model;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.history.CommandState;
import seedu.address.history.ModelState;
import seedu.address.history.exceptions.HistoryException;
import seedu.address.logic.commands.Command;
import seedu.address.model.event.Event;
import seedu.address.model.person.Person;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Person> PREDICATE_SHOW_ALL_PERSONS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setAddressBookFilePath(Path addressBookFilePath);

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setAddressBook(ReadOnlyAddressBook addressBook);

    /** Returns the AddressBook */
    ReadOnlyAddressBook getAddressBook();

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    boolean hasPerson(Person person);

    /**
     * Deletes the given person.
     * The person must exist in the address book.
     */
    void deletePerson(Person target);

    /**
     * Adds the given person.
     * {@code person} must not already exist in the address book.
     */
    void addPerson(Person person);

    /**
     * Replaces the given person {@code target} with {@code updatedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code updatedPerson} must not be the same as another existing person in the address book.
     */
    void setPerson(Person target, Person updatedPerson);

    /** Returns an unmodifiable view of the filtered person list */
    ObservableList<Person> getFilteredPersonList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    ModelState getCurrentModelState();

    void restoreModelState(ModelState modelState);

    void rollBackState() throws HistoryException;

    void rollForwardState() throws HistoryException;

    void updateModelState(Command command) throws HistoryException;

    void updateFilteredPersonList(Predicate<? super Person> predicate);

    CommandState getCurrentCommandState();

    void updateCommandState(String command);

    String retrievePreviousCommand() throws HistoryException;

    String retrieveNextCommand() throws HistoryException;
    ObservableList<Event> getEventList();

    ReadOnlyCalendar getCalendar();
    /**
     * Returns true if a person with the same identity as {@code person} exists in the calendar.
     */
    boolean hasEvent(Event event);
    /**
     * Adds a person to the address book.
     * The person must not already exist in the calendar.
     */
    void addEvent(Event event);
    /**
     * Deletes the given event.
     * The event must exist in the calendar.
     */
    void deleteEvent(Event key);
    /**
     * Replaces the contents of the events list with {@code events}.
     * {@code events} must not contain duplicate persons.
     */
    void setEvents(List<Event> events);

    void setCalendar(ReadOnlyCalendar calendar);
}
