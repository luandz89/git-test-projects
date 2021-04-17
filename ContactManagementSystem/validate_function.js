//function to validate input
function Validate() {
    var names = document.forms["Add"]["names"];
    var profession = document.forms["Add"]["profession"];
    var emailaddress = document.forms["Add"]["emailaddress"];
    var phone = document.forms["Add"]["phone"];
    var city = document.forms["Add"]["city"];
    var address = document.forms["Add"]["address"];
    var contact_group = document.forms["Add"]["contact_group"];


    if (names.value === "") {
        window.alert("Please enter your fullname.");
        names.focus();
        return false;
    }
    if (profession.value === "") {
        window.alert("Please enter your profession.");
        profession.focus();
        return false;
    }
    if (emailaddress.value === "") {
        window.alert("Please enter your email.");
        emailaddress.focus();
        return false;
    }

    if (phone.value === "") {
        window.alert(
                "Please enter your mobile number.");
        phone.focus();
        return false;

    }

    if (city.value === "") {
        window.alert(
                "Please enter a valid city.");
        city.focus();
        return false;
    }


    if (address.value === "") {
        window.alert("Please enter your address.");
        address.focus();
        return false;
    }

    if (contact_group.selectedIndex < 1) {
        alert("Please select your contact group.");
        contact_group.focus();
        return false;
    }


}