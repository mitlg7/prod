<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="Главная страница">
    <@bootstrap.navbar/>
    <div class="d-flex justify-content-center">
        <div class="col-10 row" id="ads">
            <div class="row">
                <h3 class="">Продукты, которые представлены на нашем сайте:</h3>
                <form method="get" class="input-group">
                    <#if cats??>
                        <select class="form-control " name="cat">
                            <#list cats as cat>
                                <#if catId??>
                                    <#if catId==cat.id>
                                        <option selected value="${cat.id}">${cat.type}</option>
                                    </#if >

                                <#else >
                                    <option value="${cat.id}">${cat.type}</option>
                                </#if>

                            </#list>
                        </select>
                    </#if>
                    <p class="btn">Цена</p>
                    <input class="form-control mx-2" min="0" id="min" placeholder="Минимум" name="min">
                    <input class="form-control mx-2" type="number" id="" placeholder="Максимум" max="9999999" name="max">

                    <input type="search" name="search" class="form-control rounded" placeholder="Search"
                           aria-label="Search"
                           aria-describedby="search-addon" <#if search??> value="${search}" </#if>/>
                    <button class="btn btn-outline-dark btn-warning">Найти</button>
                    <a class="btn btn-outline-dark btn-warning" href="/">Сбросить</a>
                </form>
            </div>


            <div class="main-container">
                <div class="cards row">
                    <#if products??>
                        <#list products as product>
                            <div class="col-md-4 mt-4">
                                <div class="card rounded my-3 mx-1">
                                    <div class="card-image m-3">
                                        <span class="card-notify-badge">${product.category.type}</span>
                                        <span class="card-notify-year">${product.country.name}</span>
                                        <img src="/img/${product.image}" alt=""/>
                                    </div>
                                    <div class="card-image-overlay m-auto">
                                        <span class="card-detail-badge">Название: ${product.name}</span>
                                        <span class="card-detail-badge">Цена $${product.price}</span>
                                    </div>
                                    <a href="/user/${product.userId}" class="btn btn-warning mt-3">Перейти к
                                        поставщику</a>
                                    <a href="/product/${product.id}" class="btn btn-warning mt-1">Перейти к продукту</a>

                                </div>
                            </div>

                        </#list>
                    </#if>

                    <#if notfound??>
                        <div class="container mt-4 text-center">
                            <p class="fs-4">По вашему запросу ничего не найдено =(</p>
                        </div>
                    </#if>


                </div>
            </div>
        </div>

        <style>

            /* Category Ads */

            #ads {
                margin: 30px 0 30px 0;

            }

            #ads .card-notify-badge {
                position: absolute;
                left: -10px;
                top: -20px;
                background: #dba7ef;
                text-align: center;
                border-radius: 30px 30px 30px 30px;
                color: #000;
                padding: 5px 10px;
                font-size: 14px;

            }

            #ads .card-notify-year {
                position: absolute;
                right: -10px;
                top: -20px;
                background: #78c291;
                border-radius: 50%;
                text-align: center;
                color: #fff;
                font-size: 14px;
                width: 75px;
                height: 50px;
                padding: 15px 0 0 0;
            }


            #ads .card-detail-badge {
                background: #70beea;
                text-align: center;
                border-radius: 30px 30px 30px 30px;
                color: #000;
                padding: 5px 10px;
                font-size: 14px;
            }


            #ads .card:hover {
                background: #fff;
                box-shadow: 12px 15px 20px 0px rgba(46, 61, 73, 0.15);
                border-radius: 4px;
                transition: all 0.3s ease;
            }

            #ads .card-image-overlay {
                font-size: 40px;

            }


            #ads .card-image-overlay span {
                display: inline-block;
            }


            #ads .ad-title h5 {
                text-transform: uppercase;
                font-size: 18px;
            }
        </style>
    </div>
</@component.skeleton>