# Method Security With Role Hierarchy

Application showing `GlobalMethodSecurityConfiguration` with `RoleHierarchy`.

To invoke [SecuredService,java](src/main/java/net/bjornoy/method/security/service/SecuredService.java) the user needs to
have either `Administrator` or `User` role. `Anonymous` is not allowed to invoke that class.