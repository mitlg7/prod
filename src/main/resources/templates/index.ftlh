<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="Главная страница">
    <@bootstrap.navbar/>


    <div class="row row-cols-1 row-cols-md-3 g-4">
        <#list products as product>

            <div class="col">
                <div class="card">
                    <img
                            src="https://mdbootstrap.com/img/new/standard/city/041.jpg"
                            class="card-img-top"
                            alt="Hollywood Sign on The Hill"
                    />
                    <div class="card-body">
                        <h5 class="card-title">${product.name}</h5>
                        <p class="card-text">
                            ${product.description}
                        </p>
                    </div>
                </div>
            </div>

        </#list>

        <div class="col">
            <div class="card">
                <img
                        src="https://mdbootstrap.com/img/new/standard/city/044.jpg"
                        class="card-img-top"
                        alt="Skyscrapers"
                />
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">
                        This is a longer card with supporting text below as a natural lead-in to
                        additional content. This content is a little bit longer.
                    </p>
                </div>
            </div>
        </div>
    </div>

</@component.skeleton>