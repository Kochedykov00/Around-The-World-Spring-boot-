<#include "base.ftlh" />

<#macro content>

    <head>
        <title>Profile</title>
    </head>


    <div class="container-fluid profile-page-container">
        <div class="col-11">
            <div class="row profile">
                <div class="col-6">

                    <#if user.getPhoto()??>
                        <img src="${user.getPhoto()!}" width="400"/>
                    </#if>

                </div>
                <div class="col-5 profileInfo">
                    <div class="row" id="infoAbout">
                        <div class="col-5">
                            <label for="login">Username: </label>
                            <br /><br />
                            <label for="surname">Lastname :</label>
                            <br /><br />
                            <label for="name">Firstname :</label>
                            <br /><br />
                            <label for="info">Info :</label>
                        </div>
                        <div class="col-6">
                            <h4 id="login">${user.getUsername()}</h4>
                            <br />
                            <h4 id="surname">${user.getLastname()}</h4>
                            <br />
                            <h4 id="name">${user.getFirstname()}</h4>
                            <br />

                            <#if user.getInfo()??>
                                <h4 id="info">${user.getInfo()}</h4>
                            </#if>
                        </div>
                    </div>
                    <br />

                </div>
            </div>
        </div>
    </div>
</#macro>

<@display_page />