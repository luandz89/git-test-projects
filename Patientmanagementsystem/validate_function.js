//function to validate input
function Validate() {
    var name = document.forms["Insert"]["name"];
    var surname = document.forms["Insert"]["surname"];  
    var dob = document.forms["Insert"]["dob"];
    var gender = document.forms["Insert"]["gender"];
    var phonenumber = document.forms["Insert"]["phonenumber"]
    var address = document.forms["Insert"]["address"];
    var section = document.forms["Insert"]["section"];
    var medicalaid = document.forms["Insert"]["medicalaid"];
   
    if (name.value === "") {
        window.alert("Please enter your name.");
        name.focus();
        return false;
    }
    if (surname.value === "") {
        window.alert("Please enter your surname.");
        surname.focus();
        return false;
    }
      if (dob.value === "") {
        window.alert("Please enter your date of birth.");
        dob.focus();
        return false;
    }
    
    if (gender.selectedIndex < 1) {
        alert("Please select your gender.");
        gender.focus();
        return false;
    }
     if (phonenumber.value === "") {
        window.alert(
            "Please enter your phone number.");
        phonenumber.focus();
        return false;

    }

    if (address.value === "") {
        window.alert("Please enter your address.");
        address.focus();
        return false;
    }
    if (section.value === "") {
        window.alert("Please enter your section.");
        section.focus();
        return false;
    }
    return true;

if (medicalaid.value === "") {
        window.alert("Please enter your medical aid.");
        medicalaid.focus();
        return false;
    }
    return true;
    }













