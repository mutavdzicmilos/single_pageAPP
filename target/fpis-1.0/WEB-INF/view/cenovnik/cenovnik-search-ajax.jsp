<html>
    <head>
        <link rel="stylesheet" href="https://cdn.rawgit.com/tonystar/bootstrap-float-label/v3.0.1/dist/bootstrap-float-label.min.css"/>

    </head>
    <body>
        <div class="container">
            <div class="container-fluid">
                <h2>Unos cenovnika:</h2> <hr>
                <div class="row">
                    <div class="col-sm-6">
                        <label for="sifraCenovnika">Sifra Cenovnika: </label>

                        <br>
                        <input type="text" class="form-control" id="sifraCenovnika">

                    </div>
                    <div class="col-sm-2">
                        <br>
                        <div class="btn-group-vertical">
                            <button type=button class=" btn btn-primary  btn-xs" onclick="pronadjiCenovnik()">Pronadji</button>
                            <button type=button class=" btn btn-primary  btn-xs" onclick="obrisiCenovnik()">Obrisi</button>   
                        </div>
                    </div>
                    <div class="col-sm-2">
                        <label > Datum:</label>
                        <br>
                        <input id="datum" class="form-control" type="date" style="float: right">   
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-2">
                        <label for="sifraOdgLica">Sifra Odg. Lica: </label>
                        <input type="text" id="odgLice" class="form-control">

                    </div>
                    <div class="col-sm-2">
                        <br>
                        <button class="btn btn-primary form-control" onclick="pronadji()">Pronadji Odg. Lice</button>
                    </div>
                    <div class="col-sm-2">
                        <label for="drzava">Drzava: </label>
                        <br>

                        <select class="form-control" name="Drzava" id="drzava">
                        </select>
                    </div>
                </div>
                <hr>
                <div class="container-fluid">
                    <label for="panel">Unos stavki cenovnika</label>
                    <div class="form-group has-float-label" id="panel">

                        <div class="panel-body"> 
                            <div class="row">
                                <div class="col-sm-3">
                                    <label for="proizvod">Sifra Proizvoda:</label>
                                    <input class="form-control" type="number" step="1" id="sifpr">
                                </div>
                                <div class="col-sm-2">
                                    <button class="btn btn-primary form-control" onclick="pronadjiProizvod()">Pronadji proizvod</button>
                                </div>
                                <div class="col-sm-3">
                                    <div class="form-group has-float-label">
                                        <input class="form-control" type="text" id="model" disabled="disabled">
                                        <label for="model">Naziv Modela</label>
                                    </div>
                                </div>
                                <div class="col-sm-1">
                                    <button type="button" class="btn btn-danger btn-min" onclick="ocistiProizvod()">
                                        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                    </button>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-10">
                                </div>
                                <div class="col-sm-2">
                                    <button class="btn btn-primary form-control" onclick="ubaciStavku()">Ubaci stavku</button> 
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-3"
                                     <label style="font-weight: bold">Cena bez PDV-a </label>
                                    <input class="form-control"  type="number" step="0.01"  min="0" id="cenaBezPdv">
                                </div>
                                <div class="col-sm-3"
                                     <label style="font-weight: bold">Cena sa PDV-om </label>
                                    <input class="form-control"  type="number" step="0.01"  min="0" id="cenaSaPdv">
                                </div>
                            </div>
                            <br>
                            <table class="table table-bordered" id="tabela">
                                <thead>
                                    <tr>
                                        <th>R.b</th>
                                        <th>Sifra proizvoda</th>
                                        <th>Naziv modela</th>
                                        <th>Cena bez PDV-a</th>
                                        <th>Cena sa PDV-om</th>
                                        <th>Izmeni stavku</th>
                                        <th>Obrisi stavku</th>
                                    </tr>
                                </thead>
                                <tbody>


                                </tbody>
                            </table>
                        </div>
                    </div>


                    <div class="row">
                        <button class="btn btn-primary col-sm-2" onclick="pronadjiCenovnik()" id="ponistiUnos">Ponisti unos</button>

                        <button class="btn btn-primary col-sm-2" style="float: right" disabled="true" onclick="potvrdiSacuvaj()" id="potvrda">Potvrdi unos</button>

                    </div>

                </div>

            </div>
    </body>
    <script type="text/javascript">
        $(document).ready(prepareDrzava());

        function potvrdiSacuvaj() {
            if (document.getElementById("sifraCenovnika").disabled===false) {
                document.getElementById("sifraCenovnika").value='';
            }
                $.ajax({
                    url: "api/cenovnik/save",
                    type: "POST",
                    contentType: "application/json; charset=utf-8",
                    dataType: "json",
                    data: dataForCenovnik(),
                    success: function (data) {
                        alert('Cenovnik is successfully saved! ' + data.sifracenovnika);
                         document.getElementById("sifraCenovnika").value= data.sifracenovnika;
                         pronadjiCenovnik();
                         document.getElementById("odgLice").disabled = false;
                    },
                    error: function (xhr, ajaxOptions, thrownError) {
                        alert('Unexcpected exception occurred when saving cenovnik!');
                    }
                });
           
        }
        function dataForCenovnik() {
            var odgLice = document.getElementById("odgLice").value;
            var sifraCenovnika = document.getElementById("sifraCenovnika").value;
            var datum = document.getElementById("datum").value;
            var drzava = document.getElementById("drzava").value;
            const object = {};

            object.sifracenovnika = sifraCenovnika;
            object.datum = datum;
            object.drzava = {};
            object.drzava.sifraDrzave = drzava;
            object.radnik = {};
            object.radnik.sifraradnika = odgLice;
            object.stavke = [];
            $('#tabela tr').each(function () {
                var $tds = $(this).find('td');
                if ($tds.length !== 0) {
                    var objekat = {};
                    objekat.rb = $tds.eq(0).text();
                    objekat.proizvod = {};
                    objekat.proizvod.sifraproizvoda = $tds.eq(1).text();

                    objekat.vrednostBezPdv = $tds.eq(3).text();
                    objekat.vrednost = $tds.eq(4).text();

                    object.stavke.push(objekat);
                }
            });

            return JSON.stringify(object);
        }






        function pronadji() {
            document.getElementById("potvrda").disabled = true;

            var x = document.getElementById("odgLice").value;
            if (x === null || x.trim() === "") {
                return;
            }

            $.ajax({

                url: "api/radnik/" + x,
                type: "GET",
                dataType: "json",
                success: function (data) {
                    if (data !== null) {
                        document.getElementById("odgLice").disabled = true;
                        document.getElementById("potvrda").disabled = false;
                    }
                    return;
                }

            });

        }
        function obrisiCenovnik() {
            var x = document.getElementById("sifraCenovnika").value;
            if (x === null || x.trim() === "") {
                alert("Wrong input!");
                return;
            }

            $.ajax({

                url: "api/cenovnik/delete/" + x,
                type: "DELETE",
                dataType: "json",
                success: function (data) {
                    alert('Sucessfully deleted cenovnik!');

                },
                error: function (xhr, ajaxOptions, thrownError) {
                    pronadjiCenovnik();
                }
                

            });
            document.getElementById("sifraCenovnika").value="";
            javascript:addContentFromUrl('cenovnik-div', 'cenovnik');
           // pronadjiCenovnik();
        }
        function ubaciStavku() {
            var x = document.getElementById("cenaBezPdv").value;
            var y = document.getElementById("cenaSaPdv").value;
            var sifra = document.getElementById("sifpr").value;
            var model = document.getElementById("model").value;
            if (x === null || x.trim() === "") {
                alert("Wrong input!");
                return;
            }
            if (y === null || y.trim() === "") {
                alert("Wrong input!");
                return;
            }
            if (sifra === null || sifra.trim() === "") {
                alert("Wrong input!");
                return;
            }
            if (model === null || model.trim() === "") {
                alert("Wrong input!");
                return;
            }
            var tr = document.getElementsByTagName('table')[0].rows.length;
            var tr = '';
            var count = 0;
            $('#tabela tr').each(function () {
                var $tds = $(this).find('td');
                if ($tds.length !== 0) {
                    var $currText = $tds.eq(1).text();
                    if ($currText == sifra) {
                        $tds.eq(2).text(model);
                        $tds.eq(3).text(x);
                        $tds.eq(4).text(y);
                        ocistiProizvod();
                        count++;
                    }
                }
            });
            if (count === 0) {
                dodajRed('', sifra, model, x, y);
            }

        }
        function change(x) {
            document.getElementById("sifpr").value = x.find("td").eq(1).html();
            document.getElementById("model").value = x.find("td").eq(2).html();
            document.getElementById("cenaBezPdv").value = x.find("td").eq(3).html();
            document.getElementById("cenaSaPdv").value = x.find("td").eq(4).html();
            // deleteItem(x);
        }
        function deleteItem(x) {
            x.remove();
            //      var tr = document.getElementsByTagName('table')[0].rows.length;
            //    var count = 1;
            //    $('#tabela tr').each(function () {
            //        var $tds = $(this).find('td');
            //          if ($tds.length !== 0) {
            //            var $currText = $tds.eq(0).text(count++);

            //          }
            //     });

        }
        function pronadjiCenovnik() {
            var x = document.getElementById("sifraCenovnika").value;
            if (x === null || x.trim() === "") {
                return;
            }

            $.ajax({

                url: "api/cenovnik/" + x,
                type: "GET",
                dataType: "json",

                success: function (data) {
                    if (data !== null) {
                        document.getElementById("sifraCenovnika").disabled = true;
                        var formattedDate = new Date(data.datum);
                        var d = formattedDate.getDate();
                        var m = formattedDate.getMonth();
                        m += 1;  // JavaScript months are 0-11
                        if (m < 10) {
                            m = "0" + m;
                        }
                        if (d < 10) {
                            d = "0" + d;
                        }
                        var y = formattedDate.getFullYear();
                        $('#tabela tbody > tr').remove();

                        document.getElementById("datum").value = y + "-" + m + "-" + d;
                        document.getElementById("drzava").value = data.drzava.sifraDrzave;
                        document.getElementById("odgLice").value = data.radnik.sifraradnika;
                        document.getElementById("potvrda").disabled = false;
                        jQuery.each(data.stavke, function () {

                            dodajRed(this.rb, this.proizvod.sifraproizvoda, this.proizvod.model, this.vrednostBezPdv, this.vrednost);

                        });
                    }
                    return;
                }

            });

        }
        function dodajRed(prvi, drugi, treci, cetvrti, peti) {
            $("#tabela").append('<tr><td>' + prvi + '</td><td>' + drugi + '</td><td>' + treci + '</td><td>' + cetvrti + '</td><td>' + peti +
                    '</td><td><button class="btn btn-info" onclick="change($(this).parent().parent())">Promeni</button></td><td><button class="btn btn-danger" onclick="deleteItem($(this).parent().parent())">Obrisi</button></td></tr>');
            ocistiProizvod();
        }
        function ocistiProizvod() {
            document.getElementById("sifpr").value = null;
            document.getElementById("model").value = null;
            document.getElementById("sifpr").disabled = false;
            document.getElementById("cenaBezPdv").value = null;
            document.getElementById("cenaSaPdv").value = null;
        }
        function pronadjiProizvod() {
            var x = document.getElementById("sifpr").value;
            if (x === null || x.trim() === "") {
                alert("Wrong input!");
                return;
            }

            $.ajax({

                url: "api/proizvod/" + x,
                type: "GET",
                dataType: "json",
                success: function (data) {
                    if (data !== null) {
                        document.getElementById("sifpr").value = data.sifraproizvoda;
                        document.getElementById("model").value = data.model;
                        document.getElementById("sifpr").disabled = true;
                    }
                    return;
                }

            });

        }
        function prepareDrzava() {
            $.ajax({

                url: "api/drzave/all",
                type: "GET",
                dataType: "json",
                success: function (data) {
                    $('#drzava').empty();
                    jQuery.each(data, function () {

                        var row = createRow(this.sifraDrzave, this.naziv);

                        $('#drzava').append(row);
                    });
                }
            });
        }
        function createRow(sifra, naziv) {

            let row;

            row = '<option value="' + sifra + '">'
                    + naziv
                    + '</option>';


            return row;
        }


    </script>
</html>