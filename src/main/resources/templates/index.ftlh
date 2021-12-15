<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="Главная страница">
    <@bootstrap.navbar/>
    <div class="container row" id="ads">
        <div class="heading">
            <h3 class="heading__title">Продукты, которые представлены на нашем сайте</h3>
        </div>

        <div class="main-container">
            <div class="cards row">
                <#list products as product>
                    <div class="col-md-4 mt-4">
                        <div class="card rounded">
                            <div class="card-image-overlay m-auto">
                                <span class="card-notify-badge">${product.category.type}</span>
                                <span class="card-notify-year">${product.country.name}</span>
                                <img width="250" src="/img/${product.image}" alt=""/>
                            </div>
                            <div class="card-image-overlay m-auto">
                                <span class="card-detail-badge">Название: ${product.name}</span>
                                <span class="card-detail-badge">Цена $${product.price}</span>
                            </div>
                            <a href="/user/${product.userId}" class="btn btn-warning mt-3">Перейти к поставщику</a>
                            <a href="/product/${product.id}" class="btn btn-warning mt-1">Перейти к продукту</a>

                        </div>
                    </div>

                </#list>
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
            background: #f2d900;
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
            background: #ff4444;
            border-radius: 50%;
            text-align: center;
            color: #fff;
            font-size: 14px;
            width: 75px;
            height: 50px;
            padding: 15px 0 0 0;
        }


        #ads .card-detail-badge {
            background: #f2d900;
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
</@component.skeleton>