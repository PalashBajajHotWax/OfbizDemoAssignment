<html>
  <head>
    <title>${layoutSettings.companyName}</title>
    <meta name="viewport" content="width=device-width, user-scalable=no"/>
    <#if webSiteFaviconContent?has_content>
      <link rel="shortcut icon" href="">
    </#if>
    <#list layoutSettings.styleSheets as styleSheet>
      <link rel="stylesheet" href="${StringUtil.wrapString(styleSheet)}" type="text/css"/>
    </#list>
    <#list layoutSettings.javaScripts as javaScript>
      <script type="text/javascript" src="${StringUtil.wrapString(javaScript)}"></script>
    </#list>
  </head>
  <body data-offset="125">
    <div class="container menus" id="container">
      <div class="row">
        <div class="col-sm-12">
          <ul id="page-title" class="breadcrumb">
            <li>
                <a href="<@ofbizUrl>main</@ofbizUrl>">Main</a>
            </li>
            <li>
                <a href="<@ofbizUrl>FindOfbizDemo</@ofbizUrl>">FindOfbizDemo</a>
            </li>
            <li>
                <a href="<@ofbizUrl>AddOfbizDemoFtl</@ofbizUrl>">AddOfbizDemoFtl</a>
            </li>
            <li>
                <a href="<@ofbizUrl>FindSupplier</@ofbizUrl>">FindSupplier</a>
            </li>
            <li>
                <a href="<@ofbizUrl>FindSupplierByDetail</@ofbizUrl>">FindSupplierByDetail</a>
            </li>
            <li class="pull-right">
              <a href="<@ofbizUrl>logout</@ofbizUrl>" title="${uiLabelMap.CommonLogout}">logout</i></a>
            </li>
          </ul>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-12 header-col">
          <div id="main-content">