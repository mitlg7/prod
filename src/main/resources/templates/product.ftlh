<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<#include "components/security.ftlh">
<@component.skeleton title="Страница продукта">
    <@bootstrap.navbar/>


    <div class="container">
    <div class="container mt-4">
        <div class="row">
            <div class="col-4 gutters-sm">
                <div class="mb-3">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex flex-column align-items-center text-center">

                                <img src="/img/${product.image}" alt=""
                                     class="rounded-circle" width="150">

                                <div class="mt-3">
                                    <h4>${product.name}</h4>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-7">
                <div class="card mb-3">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Подробная информация</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <#if product.id??>
                                    ${product.description}
                                </#if>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Цена</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <#if product.id??>
                                    ${product.price}
                                </#if>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <h6 class="mb-0">Дата побликации</h6>
                            </div>
                            <div class="col-sm-9 text-secondary">
                                <#if product.id??>
                                    ${product.date}
                                </#if>
                            </div>
                        </div>
                        <#if known && user?? &&( name == "admin" || name == "moder" || user.id == product.userId)>
                            <hr>
                            <form method="post" action="/product/delete">
                                <div class="row-left">
                                    <input hidden="" name="id" value="${product.id}">
                                    <button class="btn btn-warning col-md-2 ">
                                        Удалить
                                    </button>
                                </div>
                            </form>

                        </#if>

                        <hr>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <#if known>
        <form class="container m-4 row " method="post" action="/product/${product.id}/comment">
            <div class="row">
                <div class="col-sm-9 ">
                    <input type="text" class="col-12" name="comment" placeholder="Введите комментарий">
                    <div class="text-right">
                        <button class="btn btn-warning col-md-2 ">
                            Добавить
                        </button>
                    </div>
                </div>
            </div>
        </form>
    </#if>


    <#if comments??>

        <div class="container d-flex justify-content-center">
        <#list comments as comm>

            <div class="container justify-content-center mt-5  border-right">
                <div class="d-flex justify-content-center py-2">
                    <div class="second py-2 px-2"><span class="text1">${comm.message}</span>
                        <div class="d-flex justify-content-between py-1 pt-2">
                            <#--<div><img src="https://i.imgur.com/AgAC1Is.jpg" width="18">--><span
                                    class="text2">${comm.author.info.name}</span></div>
                        <div><span class="text3">${comm.date}</span><span class="text4"></span></div>
                    </div>
                </div>
            </div>
            </div>
        </#list>
        </div>
    </#if>
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
            width: 50px;
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
            font-size: 20px;

        }


        #ads .card-image-overlay span {
            display: inline-block;
        }


        #ads .ad-btn {
            text-transform: uppercase;
            width: 150px;
            height: 40px;
            border-radius: 80px;
            font-size: 16px;
            line-height: 35px;
            text-align: center;
            border: 3px solid #e6de08;
            display: block;
            text-decoration: none;
            margin: 20px auto 1px auto;
            color: #000;
            overflow: hidden;
            position: relative;
            background-color: #e6de08;
        }

        #ads .ad-btn:hover {
            background-color: #e6de08;
            color: #1e1717;
            border: 2px solid #e6de08;
            background: transparent;
            transition: all 0.3s ease;
            box-shadow: 12px 15px 20px 0px rgba(46, 61, 73, 0.15);
        }

        #ads .ad-title h5 {
            text-transform: uppercase;
            font-size: 18px;
        }

        body {
            background-color: #fff
        }

        .container1 {
            background-color: #eef2f5;
            width: 400px
        }

        .form-control: focus {
            color: #000
        }

        .second {
            width: 600px;
            background-color: white;
            border-radius: 4px;
            box-shadow: 10px 10px 5px #aaaaaa
        }

        .text1 {
            font-size: 13px;
            font-weight: 500;
            color: #56575b
        }

        .text2 {
            font-size: 13px;
            font-weight: 500;
            margin-left: 6px;
            color: #56575b
        }

        .text3 {
            font-size: 13px;
            font-weight: 500;
            margin-right: 4px;
            color: #828386
        }

        .text4 {
            font-size: 13px;
            font-weight: 500;
            color: #828386
        }


    </style>
</@component.skeleton>