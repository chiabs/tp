---
layout: page
title: User Guide
---

Hospify is a desktop app for a digital medical record management solution. 

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `hospify.jar` from [here](https://github.com/AY2021S1-CS2103T-W15-3/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for the Hospify app.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`list`** : Lists all patients.

   * **`add`**`n/John Doe ic/S1234567A p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a patient named `John Doe` to Hospify.

   * **`delete`**`3` : Deletes the 3rd patient shown in the current list.

   * **`clear`** : Deletes all patients.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME ic/S1234567A` is also acceptable.

</div>

### Displaying usage instructions : `help`

Shows a list of basic commands (and their usages) supported by Hospify.

![tp_help_command](images/helpMessage.png)

Format: `help`


### Adding a patient : `add`

Adds a patient to Hospify

Format: `add n/NAME ic/S1234567A p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A patient can have any number of tags (including 0)
</div>

Examples:
* `add n/John Doe ic/S1234567A p/98765432 e/johnd@example.com a/John street, block 123, #01-01`
* `add n/Betsy Crowe ic/S9425431A t/friend e/betsycrowe@example.com a/Newgate Prison p/1234567 t/criminal`

### Listing all patients : `list`

Shows a list of all patients in Hospify.

Format: `list`

### Editing a patient : `edit`

Edits an existing patient in Hospify.

Format: `edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`

* Edits the patient at the specified `INDEX`. The index refers to the index number shown in the displayed patient list. The index **must be a positive integer** 1, 2, 3, …​
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the patient will be removed i.e adding of tags is not cumulative.
* You can remove all the patient’s tags by typing `t/` without
    specifying any tags after it.

Examples:
*  `edit 1 p/91234567 e/johndoe@example.com` Edits the phone number and email address of the 1st patient to be `91234567` and `johndoe@example.com` respectively.
*  `edit 2 n/Betsy Crower t/` Edits the name of the 2nd patient to be `Betsy Crower` and clears all existing tags.

### Locating patients by name: `find`

Finds patients whose names contain any of the given keywords or NRICs.

Format: `find KEYWORD [MORE_KEYWORDS] [NRIC] [MORE_NRICs]`

* The search is case-insensitive. e.g. `hans` will match `Hans`, and `s1234567a` will match `S1234567A`
* The order of the keywords and NRICs does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Both the name and NRIC are searched.
* Only full words will be matched e.g. `Han` will not match `Hans`
* Only full NRICs will be matched e.g. `S12345` will not match `S1234567A`
* Patients matching at least one keyword or NRIC will be returned (i.e. `OR` search).
  e.g. `Hans Bo S7654321A` will return `Hans Gruber`, `Bo Yang`, `Tom Lee` (whose NRIC is S7654321A)

Examples:
* `find John` returns `john` and `John Doe`
* `find alex david` returns `Alex Yeoh`, `David Li`<br>
  ![result for 'find alex david'](images/findAlexDavidResult.png)
  
* `find bernice s0000003a` returns `Bernice Yu`, `Charlotte Oliveiro`
  ![result for 'find bernice s0000003a'](images/findbernices0000003aResult.png)

### Deleting a patient : `delete`

Deletes the specified patient from Hospify.

Format: `delete INDEX`<br>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; or `delete NRIC`

* Deletes the patient at the specified `INDEX` or `NRIC`
* The index refers to the index number shown in the displayed patient list.
* The index **must be a positive integer** 1, 2, 3, …​
* The NRIC refers to the NRIC of the patient to be deleted.
* The NRIC entered is **case-sensitive**. e.g. `s1234567a` will **not** match `S1234567A`

Examples:
* `list` followed by `delete 2` deletes the 2nd patient in the address book.
* `find Betsy` followed by `delete 1` deletes the 1st patient in the results of the `find` command.
* `delete S7654321A` deletes `Tom Lee` (whose NRIC is S7654321A).

### Counting total number of patients : `count`

Shows total number of patients recorded in Hospify.

Format: `count`

### Clearing all entries : `clear`

Clears all entries from the Hospify.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

Hospify data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Archiving data files `[coming in v2.0]`

_{explain the feature here}_

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add** | `add n/NAME ic/NRIC p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​` <br> e.g., `add n/James Ho ic/S1234567A p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague`
**Clear** | `clear`
**Delete** | `delete INDEX`<br> e.g., `delete 3`<br> `delete NRIC`<br> e.g., `delete S1234567A`
**Edit** | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [ic/NRIC] [t/TAG]…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com ic/S1234567A`
**Find** | `find KEYWORD [MORE_KEYWORDS] [NRIC] [MORE_NRICs]`<br> e.g., `find James Jake`<br> e.g., `find Curry Davis Heskey S1234567A`
**List** | `list`
**Help** | `help`
**Count** | `count`
