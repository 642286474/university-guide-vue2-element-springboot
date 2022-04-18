// Element组件使用
import Vue from 'vue'
// 用于导入Element组件
import { Notification, Icon, Message, Dialog, Popover, Button, Menu, MenuItem, Submenu, Form, FormItem, Input, Dropdown, DropdownItem, DropdownMenu } from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

// 使用Element组件

Vue.use(Icon)
Vue.use(Dialog)
Vue.use(Popover)
Vue.use(Button)
Vue.use(Menu)
Vue.use(MenuItem)
Vue.use(Submenu)
Vue.use(Form)
Vue.use(FormItem)
Vue.use(Input)
Vue.use(DropdownMenu)
Vue.use(DropdownItem)
Vue.use(Dropdown)
Vue.prototype.$message = Message
Vue.prototype.$notify = Notification