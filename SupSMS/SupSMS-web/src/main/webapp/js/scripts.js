
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
                "required": true,
                number: true,
                minlength: 12
            },
            "password": {
                "required": true
            }

        },
        //les messages d'erreurs selon chaque rule
        messages: {
            nom: "Veuillez saisir votre nom",
            prenom: "Veuillez saisir votre prénom",
            password: "Veuillez saisir un mot de passe",
            carteCredit: {
                required: "Veuillez votre numéro de carte de crédit",
                number: "Format du numéro de carte de crédit incorrect",
                minlength: "Format du numéro de carte de crédit incorrect"
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
                minlength:5,
                maxlenght:5
            }            

        },
        //les messages d'erreurs selon chaque rule
        messages: {
            nom: "Veuillez saisir le nom du contact",
            prenom: "Veuillez saisir le prénom du contact",
            boitePostale: {
                required: "Veuillez saisir le code postale du contact",
                number: "Veuillez saisir des chiffres",
                minlength: "format incorrect de boîte postale",
                maxlenght: "format incorrect de boîte postale",
            },
            email: {
                required: "Veuillez saisir une adresse mail pour le contact",
                email: "Format de l'adresse mail incorrect"
            },
            telephone: {
                required: "Veuillez saisir le numéro de téléphone du contact",
                number: "Veuillez saisir des chiffres",
                minlength: "format incorrect du numéro de téléphone"
            }

        }
    });
    //formulaire d'envoi de message
    $("#send-message-form").validate({
        //règles de validations s'établi sur les attributs "name des balises"
        rules: {
            "numeroRecepteur": {
                "required": true,
                number: true,
                minlength: 10
            },
            "contenu": {
                "required": true
            }     

        },
        //les messages d'erreurs selon chaque rule
        messages: {            
            numeroRecepteur: {
                required: "Veuillez saisir le numéro du destinataire",
                number: "Veuillez saisir des chiffres",
                minlength: "format incorrect du numéro de téléphone"
            },
            contenu: {
                required: "Veuillez saisir le contenu de votre SMS"
            }            
        }
    });
    //formulaire de connexion
    $("#connexion-form").validate({
        //règles de validations s'établi sur les attributs "name des balises"
        rules: {
            "login": {
                "required": true                
            },
            "password": {
                "required": true
            }     

        },
        //les messages d'erreurs selon chaque rule
        messages: {            
            login: {
                required: "Veuillez saisir votre login"                
            },
            password: {
                required: "Veuillez saisir votre mot de passe"
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