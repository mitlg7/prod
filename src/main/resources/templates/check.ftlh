<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="Главная страница">
    <@bootstrap.navbar/>
        <#if check??>
            <#if check>
                <p class="alert alert-success fs-4 container col-6">Проверка пройдена, теперь вы можете войти</p>
            <#else >
                <p class="fs-4 alert alert-danger container col-6" >Проверка токена не пройдена, попробуй её раз.</p>
                <form class="container col-8 mt-4" action="/check" method="get">
                    <div class="form-group">
                        <label for=" fs-4 mb-3">Токен пришедший вам на почту: </label>
                        <input name="token" type="text" maxlength="100" class="form-control" id="token" placeholder="Токен">
                    </div>

                    <div class="row">
                        <button class="mx-auto col-8 btn btn-warning mt-5 btn-lg">Проверить</button>
                    </div>
                </form>
            </#if>
        <#else >
            <form class="container col-8 mt-4" action="/check" method="get">
                <div class="form-group">
                    <label for=" fs-4 mb-3">Токен пришедший вам на почту: </label>
                    <input name="token" type="email" class="form-control" id="token" placeholder="Токен">
                </div>

                <div class="row">
                    <button class="mx-auto col-8 btn btn-warning mt-5 btn-lg">Проверить</button>
                </div>
            </form>
        </#if>


</@component.skeleton>
