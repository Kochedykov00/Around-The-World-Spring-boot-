<#include "base.ftlh" />

<#macro content>

    <head>
        <title>Creating article</title>
    </head>

    <script>
        function sendFile() {
            // данные для отправки
            let formData = new FormData();
            // забрал файл из input
            let files = ($('#file'))[0]['files'];
            // добавляю файл в formData
            [].forEach.call(files, function (file, i, files) {
                formData.append("file", file);
            });

            $.ajax({
                type: "POST",
                url: "/files",
                data: formData,
                processData: false,
                contentType: false
            })
                .done(function (response) {
                    let fileUrl = 'http://localhost/files/' + response;
                    $('#photo').attr('value', '' + fileUrl);
                })
                .fail(function () {
                    alert('Error')
                });
        }
    </script>


    <div class="mt-7">
        <h1 class="mb-lg-5"><img src="../photo/write_article.png">&nbsp;&nbsp;Write article</h1>
    </div>

    <form method="post" enctype="multipart/form-data">

        <div class="container-fluid ">

            <div class="col-11">
                <div >
                    <div class="row" id="infoAbout" style="margin-left: 30%; margin-top: 5%">
                        <div class="col-2">
                            <label for="name">Name : </label>
                            <br /><br/>
                            <label for="text">text:</label>
                        </div>
                        <div class="col-5">
                            <input type="text" name="title" class="form-control" placeholder="title" id="title">
                            <br />
                            <div class="form-group">
                                <textarea oninput="counting(300)" id="text" class="form-control" rows="5" name="text"></textarea>
                            </div>
                            <h6>May add <span id="count">300</span> symbols</h6>
                        </div>
                    </div>
                    <br />
                </div>
                <div class="form-group" style="margin-top: 1%; margin-left: 30%">

                    <div class="form-group row">
                        <input type="file" id="file" name="file" placeholder="Name..."/>
                        <input type="button" onclick="sendFile()" class="btn btn-primary mb-2" value="Ok"/>
                    </div>
                    <input type="hidden" id="photo" name="photo" value=" ">

            </div>
            <div class="container" >
                <div class="col-5" style="margin-left: 37%">
                    <button style="background-color: rgba(58,49,148,0.91)" value="save" type="submit" id="submit"  class="btn btn btn-primary border-black mx-4 btn-lg px-15 mt-4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Create&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
                </div>
            </div>
        </div>
    </form>


</#macro>

<@display_page />