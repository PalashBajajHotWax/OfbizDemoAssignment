<#if errorMessageList?has_content>
<div class="alert alert-block alert-error alert-danger fade in">
  <#list errorMessageList as errorMessage>
    ${errorMessage!}
  </#list>
</div>
</#if>
