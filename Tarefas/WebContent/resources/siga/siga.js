var Siga = {};

Siga.ModalDinamicoCount = 0;
Siga.KeyDownEnter = true;

Siga.Decimal = function () {
    return {
        TryParse: function (sender) {
            if (!isNaN(parseFloat(sender)))
            {
                return parseFloat(sender);
            }

            return 0;
        },

        ConverterNumeroCientifico: function (valor) {
            var data = String(valor).split(/[eE]/);
            if (data.length == 1) return data[0];

            var z = '', sign = valor < 0 ? '-' : '',
            str = data[0].replace('.', ''),
            mag = Number(data[1]) + 1;

            if (mag < 0) {
                z = sign + '0.';
                while (mag++) z += '0';
                return z + str.replace(/^\-/, '');
            }
            mag -= str.length;
            while (mag--) z += '0';

            return str + z;
        }
    }
}();

Siga.Int32 = function () {
    return {
        TryParse: function (sender) {
            if (!isNaN(parseInt(sender))) {
                return parseInt(sender);
            }

            return 0;
        }
    }
}();

Siga.String = function () {
    return {
        PadLeft: function (num, size) {
            var s = "000000000" + num;
            return s.substr(s.length - size);
        }
    }
}();

Siga.String = function () {
    return {
        LeftPad: function (str, padString, length) {
            str = str.toString();
            while (str.length < length)
                str = padString + str;
            return str;
        },

        RightPad: function (str, padString, length) {
            str = str.toString();
            while (str.length < length)
                str = str + padString;
            return str;
        }
    }
}();

String.prototype.replaceAll = function (str1, str2, ignore) {
    return this.replace(new RegExp(str1.replace(/([\/\,\!\\\^\$\{\}\[\]\(\)\.\*\+\?\|\<\>\-\&])/g, "\\$&"), (ignore ? "gi" : "g")), (typeof (str2) == "string") ? str2.replace(/\$/g, "$$$$") : str2);
};