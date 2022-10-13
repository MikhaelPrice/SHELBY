<#import "parts/common.ftlh" as c>

<@c.page>
<html lang="en">
<body class="text-center">
<style>
.form {
    width: 250px;
    padding: 22px;
    border-radius: 10px;
    box-shadow: 0 4px 16px #ccc;
    font-family: sans-serif;
    letter-spacing: 1px;
}

.form__input,
.form__button {
    font-family: sans-serif;
    letter-spacing: 1px;
    font-size: 16px;
}

.form__title {
    text-align: center;
    margin: 0 0 32px 0;
    font-weight: normal;
}

.form__group {
    position: relative;
    margin-bottom: 32px;
}

.form__label {
    position: absolute;
    top: 0;
    z-index: -1;
    color: #9e9e9e;
    transition: 0.3s;
}

.form__input {
    width: 100%;
    padding: 0 0 10px 0;
    border: none;
    border-bottom: 1px solid #e0e0ee;
    background-color: transparent;
    outline: none;
    transition: 0.3s;
}

.form__select {
    width: 100%;
    min-width: 15ch;
    max-width: 30ch;
    border: 2px solid var(--select-border);
    border-radius: 0.25em;
    padding: 0.25em 0.5em;
    font-size: 1.25rem;
    cursor: pointer;
    line-height: 1.1;
    background-color: #fff;
    background-image: linear-gradient(to top, #f9f9f9, #fff 33%);
}

.form__input:focus {
    border-bottom: 1px solid #1a73a8;
}

.form__button {
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    color: #fff;
    background-color: #0071f0;
    outline: none;
    cursor: pointer;
    transition: 0.3s;
}

.form__button:focus,
.form__button:hover {
    background-color: rgba(0, 113, 240, 0.7);
}

.form__input:focus ~ .form__label,
.form__input:not(:placeholder-shown) ~ .form__label {
    top: -18px;
    font-size: 12px;
    color: #e0e0ee;
}

form > div > input[type="text"]:valid,
form > div > input[type="email"]:valid,
form > div > input[type="phone"]:valid,
form > div[type="g-recaptcha"]:valid {
    background: url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/3/check.svg);
    -webkit-background-sizing: 20px;
    background-size: 20px;
    background-repeat: no-repeat;
    background-position: 20px 20px;
}

form > div > input[type="text"]:valid + label,
form > div > input[type="email"]:valid + label,
form > div > input[type="phone"]:valid + label{
    opacity: 0;
}

form > div > input[type="text"]:invalid:not(:focus):not(:placeholder-shown),
form > div > input[type="email"]:invalid:not(:focus):not(:placeholder-shown),
form > div > input[type="phone"]:invalid:not(:focus):not(:placeholder-shown),
form > div[type="g-recaptcha"]:invalid:not(:focus):not(:placeholder-shown) {
    background: pink;
}

form > div > input[type="text"]:invalid:not(:focus):not(:placeholder-shown) + label,
form > div > input[type="email"]:invalid:not(:focus):not(:placeholder-shown) + label,
form > div > input[type="phone"]:invalid:not(:focus):not(:placeholder-shown) + label{
    opacity: 0;
}

form > div > input[type="text"]:invalid:not(:focus):not(:placeholder-shown) ~ .requirements,
form > div > input[type="email"]:invalid:not(:focus):not(:placeholder-shown) ~ .requirements,
form > div > input[type="phone"]:invalid:not(:focus):not(:placeholder-shown) ~ .requirements,
form > div[type="g-recaptcha"]:invalid:not(:focus):not(:placeholder-shown) ~ .requirements{
    max-height: 200px;
    padding: 0 30px 20px 50px;
}

form > div .requirements {
    padding: 0 30px 0 50px;
    color: #999;
    max-height: 0;
    transition: 0.28s;
    overflow: hidden;
    color: red;
    font-style: italic;
}


</style>
<table>
        <tr>
            <a href="https://www.binance.com/ru/trade/BTC_BUSD?_from=markets&theme=dark&type=spot">
                <img src="https://th.bing.com/th/id/R.af70f420674480db6acfe6ae45fe8111?rik=xVoH46o42oibQA&pid=ImgRaw&r=0"
                     width="90" height="90">
            </a>
            <a href="https://www.binance.com/ru/trade/ETH_BUSD?_from=markets&theme=dark&type=spot">
                <img src="https://www.bing.com/th?id=OSK.cbb37f3c2cdfcdf60e643e38ca3fd00b&w=116&h=156&c=7&o=6&dpr=1.5&pid=SANGAM"
                     width="80" height="80">
            </a>
            <a href="https://www.binance.com/ru/trade/SOL_BUSD?_from=markets&theme=dark&type=spot">
                <img src="https://www.bing.com/th?id=OIP.5-Y1HHQJhdV8yagVLffrTQAAAA&w=178&h=185&c=8&rs=1&qlt=90&o=6&dpr=1.5&pid=3.1&rm=2"
                     width="60" height="60">
            </a>
            <a href="https://www.binance.com/ru/trade/ADA_BUSD?_from=markets&theme=dark&type=spot">
                <img src="https://www.bing.com/th?id=OIP.hkccP44tA-jUr9PzEL0A1AHaHa&w=178&h=185&c=8&rs=1&qlt=90&o=6&dpr=1.5&pid=3.1&rm=2"
                     width="65" height="65">
            </a>
            <a href="https://www.binance.com/ru/trade/BNB_BUSD?_from=markets&theme=dark&type=spot">
                <img src="https://www.bing.com/th?id=OIP.vymlAfH4dRga94BAYd_IngHaHa&w=180&h=185&c=8&rs=1&qlt=90&o=6&dpr=1.5&pid=3.1&rm=2"
                     width="75" height="75">
            </a>
            <a href="https://www.binance.com/ru/trade/XRP_BUSD?_from=markets&theme=dark&type=spot">
                <img src="https://www.bing.com/th?id=OIP.GTdUJ47NxsO3f1t3KjeWoQHaH5&w=170&h=185&c=8&rs=1&qlt=90&o=6&dpr=1.5&pid=3.1&rm=2"
                     width="75" height="75">
            </a>
        </tr>
        <tr>
            <a href="https://www.binance.com/ru/trade/ATOM_BUSD?_from=markets&theme=dark&type=spot">
                <img src="https://www.bing.com/th?id=OIP.zKluHihe9avpRJ4jhSxDcwHaHa&w=178&h=185&c=8&rs=1&qlt=90&o=6&dpr=1.5&pid=3.1&rm=2"
                     width="60" height="60">
            </a>
            <a href="https://www.binance.com/ru/trade/SHIB_BUSD?_from=markets&theme=dark&type=spot">
                <img src="https://www.bing.com/th?id=OIP.B9uAog-_ct_sfOrbPD-YcAHaHa&w=150&h=150&c=8&rs=1&qlt=90&o=6&dpr=1.5&pid=3.1&rm=2"
                     width="60" height="60">
            </a>
            <a href="https://www.binance.com/ru/trade/DOGE_BUSD?_from=markets&theme=dark&type=spot">
                <img src="https://www.bing.com/th?id=OIP.9q6cXg2co2qkop56Goc9YAHaFI&w=178&h=185&c=8&rs=1&qlt=90&o=6&dpr=1.5&pid=3.1&rm=2"
                     width="140" height="140">
            </a>
            <a href="https://www.binance.com/ru/trade/LTC_BUSD?_from=markets&theme=dark&type=spot">
                <img src="https://www.bing.com/th?id=OIP.4IBVCph705Qj1-kXi8wBUQHaFj&w=147&h=106&c=8&rs=1&qlt=90&o=6&dpr=1.5&pid=3.1&rm=2"
                     width="140" height="80">
            </a>
            <a href="https://www.binance.com/ru/trade/DASH_BUSD?_from=markets&theme=dark&type=spot">
                <img src="https://www.bing.com/th?id=ODL.dd541c498b59fcc4be1c80770a0e1bee&w=100&h=100&c=12&pcl=faf9f7&o=6&dpr=1.5&pid=13.1"
                     width="80" height="80">
            </a>
            <a href="https://www.binance.com/ru/trade/AVAX_BUSD?_from=markets&theme=dark&type=spot">
                <img src="https://www.bing.com/th?id=OIP.TvlWRMCWV8iz5lgCY8uaYwHaHa&w=170&h=185&c=8&rs=1&qlt=90&o=6&dpr=1.5&pid=3.1&rm=2"
                     width="60" height="60">
            </a>
        </tr>
        <tr align="right">
            <a href="https://www.binance.com/ru/trade/LUNC_BUSD?_from=markets&theme=dark&type=spot">
                <img src="https://lcw.nyc3.cdn.digitaloceanspaces.com/production/currencies/64/lunc.webp"
                     width="60" height="60">
            </a>
            <a href="https://www.binance.com/ru/trade/NEXO_BUSD?_from=markets&theme=dark&type=spot">
                <img src="https://www.bing.com/th?id=OIP.gSuAwyVgUTnR4UasZZ3fegHaHx&w=166&h=185&c=8&rs=1&qlt=90&o=6&dpr=1.5&pid=3.1&rm=2"
                     width="60" height="60">
            </a>
            <a href="https://www.binance.com/ru/trade/AGIX_BTC?_from=markets&theme=dark&type=spot">
                <img src="https://www.bing.com/th?id=OIP.OYKFmf4oBtd-S_Mh6YEAFAAAAA&w=160&h=120&c=7&o=6&dpr=1.5&pid=SupCap"
                     width="60" height="60">
            </a>
            <a href="https://www.binance.com/ru/trade/WABI_BTC?_from=markets&theme=dark&type=spot">
                <img src="https://www.bing.com/th?id=OIP.KvRczB8f3i-2uVrSEuDU6AAAAA&w=175&h=185&c=8&rs=1&qlt=90&o=6&dpr=1.5&pid=3.1&rm=2"
                     width="60" height="60">
            </a>
            <a href="https://www.binance.com/ru/trade/PIVX_BTC?_from=markets&theme=dark&type=spot">
                <img src="https://www.bing.com/th?id=OIP.GlF9FbgbY2PKkxau9gfcPAHaH0&w=168&h=185&c=8&rs=1&qlt=90&o=6&dpr=1.5&pid=3.1&rm=2"
                     width="70" height="70">
            </a>
            <a href="https://www.binance.com/ru/trade/MOB_BUSD?_from=markets&theme=dark&type=spot">
                <img src="https://www.bing.com/th?id=OIP.WcXTPjgRsTL62idIf-XGowHaHa&w=174&h=185&c=8&rs=1&qlt=90&o=6&dpr=1.5&pid=3.1&rm=2"
                     width="70" height="70">
            </a>
        </tr>
</table>
    <form class="form" action="/cryptocurrency">
        <p><h5 name="Greeting" class="form__title">Cryptocurrency price</h5>
        <div class="form__group">
            <input name="symbol" id="symbol" type="text" class="form__input" value="${symbol}"
                   placeholder="Enter a token name">
            <label class="form__label" for="symbol">Enter a token name</label>
        </div>
        <button class="form__button" type="submit">Show price</button>
        <br>
        <br>
        <div class="form__group">
            <output name="price" class="form__input" align="left">
                <#if price??>
                ${price}
            </#if>
        </div>
    </form>
</body>
</html>
</@c.page>