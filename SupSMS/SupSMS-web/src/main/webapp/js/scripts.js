
$(document).ready(function() {
    $(".alert").addClass("in").fadeOut(4500);

    /* swap open/close side menu icons */
    $('[data-toggle=collapse]').click(function() {
        // toggle icon
        $(this).find("i").toggleClass("glyphicon-chevron-right glyphicon-chevron-down");
    });
    //formulaire d'inscription
    $("#add-user-form").validate({
        //règles de validations s'établi sur les attributs "name des balises"
        rules: {
            "nom": {
                "required": true,
            },
            "prenom": {
                "required": true
            },
            "telephone": {
                "required": true,
                number: true,
                minlength: 10
               //"telephone": /^(\001\.|9)[0-9]{7}$/
            },
            "email": {
                "required": true,
                "email": true,
                "maxlength": 255
            },
            "carteCredit": {
                "required": true
            },
            "password": {
                "required": true
            }

        },
        //les messages d'erreurs selon chaque rule
        messages: {
            nom: "Veuillez saisir votre nom",
            prenom: "Veuillez saisir votre prénom",
            carteCredit: "Veuillez saisir votre numéro de carte de crédit",
            password: "Veuillez saisir un mot de passe",
            email: {
                required: "Veuillez saisir votre adresse mail",
                email: "Format de l'adresse mail incorrect"
            },
            telephone: {
                required: "Veuillez saisir votre numéro de téléphone",
                number: "Veuillez saisir des chiffres",
                minlength: "format incorrect du numéro de téléphone"
            }

        }
    });
    //formulaire d'ajout de contact
    $("#add-contact-form").validate({
        //règles de validations s'établi sur les attributs "name des balises"
        rules: {
            "nom": {
                "required": true,
            },
            "prenom": {
                "required": true
            },
            "telephone": {
                "required": true,
                number: true,
                minlength: 10
               //"telephone": /^(\001\.|9)[0-9]{7}$/
            },
            "email": {
                "required": true,
                "email": true,
                "maxlength": 255
            },
            "boitePostale": {
                "required": true,
                number : true,
                minlength:5
            }            

        },
        //les messages d'erreurs selon chaque rule
        messages: {
            nom: "Veuillez saisir votre nom",
            prenom: "Veuillez saisir votre prénom",
            boitePostale: {
                required: "Veuillez saisir votre adresse mail",
                number: "Veuillez saisir des chiffres",
                minlength: "format incorrect du numéro de téléphone"
            },
            email: {
                required: "Veuillez saisir votre adresse mail",
                email: "Format de l'adresse mail incorrect"
            },
            telephone: {
                required: "Veuillez saisir votre numéro de téléphone",
                number: "Veuillez saisir des chiffres",
                minlength: "format incorrect du numéro de téléphone"
            }

        }
    });
    jQuery.validator.addMethod(
            "telephone",
            function(value, element, regexp) {
                if (regexp.constructor != RegExp)
                    regexp = new RegExp(regexp);
                else if (regexp.global)
                    regexp.lastIndex = 0;
                return this.optional(element) || regexp.test(value);
            }, "format du numéro non valide"
            );
});