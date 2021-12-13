<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="Страница продукта">
    <@bootstrap.navbar/>
    <div class="container" style="margin-top:50px;">
        <div class="row">
            <#list users as user>
                <div class="col-md-3">
                    <div class="card-sl">
                        <#if user.info??>
                            <div class="card-image">
                                <img src="/img/${user.info.image}">
                            </div>
                            <#else >
                                <div class="card-image">

                                    <img src="https://images.pexels.com/photos/1149831/pexels-photo-1149831.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940"/>
                                </div>
                        </#if>


                        <a class="card-action" href="#"><i class="fa fa-heart"></i></a>
                        <div class="card-heading">
                            Audi Q8
                        </div>
                        <div class="card-text">
                            ${user.login}
                        </div>
                        <div class="card-text">
                            <#if user.info??>
                                ${user.info.phone}
                            </#if>
                        </div>


                        <a href="/user/${user.id}" class="card-button">Перейти</a>
                    </div>
                </div>
            </#list>

        </div>
    </div>

</@component.skeleton>