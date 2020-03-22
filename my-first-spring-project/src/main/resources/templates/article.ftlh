<#include "base.ftlh" />

<#macro content>

<head>
    <title>Article</title>
</head>

</br></br>

<div class="container-fluid page-container">
    <div class="row">
        <div class="col-5">

            <img class="photoArticle" src="${article.getPhoto()!}">

            <div class="row" id="aboutArticle">
                <div class="col-5">
                    <label for="author"></label>
                    <br /><br />
                    <label for="date"></label>
                </div>
                <div class="col-6">

                    <br /><br/>
                    <h4 id="date">${article.getDate()}</h4>
                </div>
            </div>
        </div>
        </br></br>



        <div class="col-6">
            <div align="center"><h2>${article.getTitle()}</h2></div>
            <div class="textArt text-div">
                ${article.getText()}
            </div>
            <form method="post" class="addRating">
                <div class="row" >
                    <div class="row" style="font-size: large; margin-top: 5%;">
                        <div class="col-9">

                        </div>
                        <div class="col-3">
                            <h4 id="rating">rating ${article.getRating()}</h4>
                            <input type="submit" name="rating" class="btn btn-outline-primary" value="plus"/>
                        </div>
                    </div>


                </div>
            </form>

        </div>
    </div>
</div>

</#macro>

<@display_page />