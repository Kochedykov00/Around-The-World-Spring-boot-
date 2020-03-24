<#include "base.ftlh"/>

<#macro content>
    <head>
        <title>Edit</title>
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


    <form method="post" enctype="multipart/form-data">
        <div class="container-fluid profile-page-container">
            <div class="col-11">
                <div class="row profile">
                    <div class="col-6">

                        <div class="form-group">
                            <#if user.getPhoto()??>
                                <img src="${user.getPhoto()!}" width="400"/>
                            </#if>


                            <div class="form-group row">
                                <input type="file" id="file" name="file" placeholder="Name..."/>
                                <input type="button" onclick="sendFile()" class="btn btn-primary mb-2" value="Ok"/>
                            </div>
                            <input type="hidden" id="photo" name="photo" value=" ">

                        </div>
                    </div>
                    <div class="col-5 profileInfo">
                        <div class="row" id="infoAbout">
                            <div class="col-5">
                                <label for="login">Login : </label>
                                <br /><br />
                                <label for="surname">Lastname :</label>
                                <br /><br />
                                <label for="name">Firstname :</label>
                                <br /><br />
                                <label for="aboutMe">About Me :</label>
                            </div>
                            <div class="col-6">
                                <input type="text" name="username" value="${user.getUsername()}" class="form-control" placeholder="login" id="login">
                                <br />
                                <input type="text" value = "${user.getLastname()}" name="lastname" class="form-control" placeholder="surname" id="surname">
                                <br />
                                <input type="text"  value = "${user.getFirstname()}"  name="firstname" class="form-control" placeholder="name" id="name">
                                <br />
                                <#if user.getInfo()??>
                                    <input type="text" value="${user.getInfo()}" name="info" class="form-control" placeholder="info" id="info">
                                <#else >
                                    <input type="text"  name="info" class="form-control" placeholder="aboutMe" id="aboutMe">
                                </#if >

                            </div>
                        </div>
                        <br />

                    </div>
                </div>
            </div>
            <div class="container" >
                <div class="col-5" style="margin-left: 37%">
                    <button  style="background-color: rgba(58,49,148,0.91)" value="save" type="submit" name="submit" id="submit"  class="btn btn btn-primary border-black mx-4 btn-lg px-15 mt-4">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Change&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
                </div>
            </div>
        </div>
    </form>
</#macro>

<@display_page />