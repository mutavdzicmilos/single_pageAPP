<body>
    <div class="container">
        <h1>Unos speditera:</h1>
        <hr>
        <div class="container-fluid">



            <div class="row">
                <div class="col-sm-4">
                    <label for="sifraSpeditera">Sifra Speditera: </label>
                    <input type="text" class="col-sm-3 form-control" id="spediter">
                </div>
                <div class="col-sm-1">
                    <br>

                    <button type=button class=" btn btn-primary btn-md" id="nadjiSpeditera" onclick="pronadji()">Pronadji</button>
                </div>
                <div class="col-sm-1">
                    <br>
                    <button type="button" class="btn btn-danger btn-md" onclick="deleteSpediter()">
                        <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                    </button>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-sm-3">
                    <label for="sifraSpeditera">Naziv Speditera: </label>
                    <br>
                    <input type="text" class="form-control" id="naziv">
                </div>
                <div class="col-sm-3">
                    <label for="sifraSpeditera">Email: </label>
                    <br>
                    <input type="text" class="form-control" id="email">

                </div>
                <div class="col-sm-3">
                    <label for="sifraSpeditera">Fax: </label>
                    <br>
                    <input type="text" class="form-control" id="fax">
                </div>
                <div class="col-sm-3">
                    <label for="sifraSpeditera">Broj telefona: </label>
                    <br>
                    <input type="text" class="form-control" id="telefon">
                </div>
            </div>

            <br>

            <div class="row">


                <div class="col-sm-2"> 
                    <label for="sifraSpeditera">Drzava: </label>
                    <br>
                    <select class="form-control"  onchange="prepareGrad(this.value)" name="Drzava" id="drzava1">
                    </select>
                </div>
                <div class="col-sm-2"> 

                </div>
                <div class="col-sm-2"> 
                    <label for="grad">Grad </label>
                    <br>
                    <select class="form-control" name="Grad" id="grad" disabled="disabled">
                    </select>
                </div>
                <div class="col-sm-2"> 

                </div>
                <div class="col-sm-3"> 
                    <label for="sifraSpeditera">Ulica i broj: </label>
                    <br>
                    <input type="text" class="form-control" id="br">
                </div>

            </div>
            <br>
            <br>
            <div class="row">
                <button class="btn btn-primary col-sm-2" onclick="ponisti()">Ponisti unos</button>

                <button class="btn btn-primary col-sm-2" style="float: right" onclick="saveSpediter()">Potvrdi unos</button>

            </div>
        </div>


    </div>
    <script type="text/javascript">
        $(document).ready(prepareDrzava1());
        function ponisti() {
            document.getElementById("spediter").value = null;
            document.getElementById("naziv").value = null;
            document.getElementById("email").value = null;
            document.getElementById("fax").value = null;
            document.getElementById("telefon").value = null;
            document.getElementById("br").value = null;
            document.getElementById("drzava1").value = null;
            document.getElementById("grad").value = null;
            document.getElementById("spediter").disabled = false;
            prepareDrzava1();

        }
        function prepareGrad(sifraDrzave) {

            $.ajax({
                url: "api/gradovi/drzava/" + sifraDrzave,
                type: "GET",
                async: false,
                dataType: "json",
                success: function (data) {
                    $('#grad').empty();
                    document.getElementById("grad").disabled = false;

                    jQuery.each(data, function () {

                        var row = '<option value="' + this.postanskiBroj + '")>'
                                + this.naziv
                                + '</option>';

                        $('#grad').append(row);
                    });
                }
            });


        }
        function pronadji() {
            var x = document.getElementById("spediter").value;
            if (x === null || x.trim() === "") {
                alert("Wrong input!");
                return;
            }

            $.ajax({

                url: "api/spediteri/" + x,
                type: "GET",
                dataType: "json",
                async: false,
                success: function (data) {
                    if (data !== null) {
                        document.getElementById("naziv").value = data.naziv;
                        document.getElementById("email").value = data.email;
                        document.getElementById("fax").value = data.fax;
                        document.getElementById("telefon").value = data.brojTelefona;
                        document.getElementById("br").value = data.ulicaIBroj;
                        document.getElementById("drzava1").value = data.grad.sifraDrzave.sifraDrzave;
                        prepareGrad(data.grad.sifraDrzave.sifraDrzave);
                        document.getElementById("grad").value = data.grad.postanskiBroj;
                        document.getElementById("spediter").disabled = true;
                    }
                    return;
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    alert('Cant find spediter!');
                }
            });

        }
        function prepareDrzava1() {
            $.ajax({

                url: "api/drzave/all",
                type: "GET",
                dataType: "json",
                success: function (data) {
                    $('#drzava1').empty();
                    jQuery.each(data, function () {

                        var row = createRow(this.sifraDrzave, this.naziv);

                        $('#drzava1').append(row);
                    });
                }
            });
            prepareGrad(1);
        }
        function createRow(sifra, naziv) {

            let row;

            row = '<option value="' + sifra + '">'
                    + naziv
                    + '</option>';


            return row;
        }
        function createSpediterJson() {
            return JSON.stringify({
                sifraSpeditera: $('#spediter').val(),
                naziv: document.getElementById("naziv").value,
                email: document.getElementById("email").value,
                fax: document.getElementById("fax").value,
                brojTelefona: document.getElementById("telefon").value,
                ulicaIBroj: document.getElementById("br").value,

                grad: {
                    postanskiBroj: document.getElementById("grad").value

                }
            });
        }

        function saveSpediter() {
            $.ajax({
                url: "api/spediteri/save",
                type: "POST",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                data: createSpediterJson(),
                success: function (data) {
                    alert('Spediter is successfully saved! ');
                    document.getElementById("spediter").value = data.sifraSpeditera;
                    document.getElementById("spediter").disabled = true;
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    alert('Unexcpected exception occurred when saving spediter!');
                }
            });
        }

        function deleteSpediter() {
             var x = $('#spediter').val();
            if (x === null || x.trim() === "") {
                alert("Wrong input!");
                return;
            }
            $.ajax({
                url: "api/spediteri/delete/" + x,
                type: "DELETE",
              
                success: function () {
                    alert('Spediter is successfully deleted! ');
                }
              
            });
            ponisti();
        }


    </script>
</body>



