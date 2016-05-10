import com.twitter.*

class BootStrap {

    def init = { servletContext ->
        def role = Role.findOrSaveByAuthority('ROLE_USER');
        def user = new Profile(username: 'a', password: 'a',
                email: 'artem2549@gmail.com', firstName: 'Artem', lastName: 'Baranovskiy').save()
        user.addToMessages(new Message(content: 'a first')).addToMessages(new Message(content: 'a second'))
        ProfileRole.create user, role, true
        user = new Profile(username: 'b', password: 'b', email: 'aaa@mail.com',
            firstName: 'Zadral', lastName: 'Menya').save()
        user.addToMessages(new Message(content: 'b first')).addToMessages(new Message(content: 'b second'))
        ProfileRole.create user, role, true
        user = new Profile(username: 'c', password: 'c', email: 'ccc@mail.com',
                firstName: 'Poshel', lastName: 'Von').save()
        user.addToMessages(new Message(content: 'c first')).addToMessages(new Message(content: 'c second'))
        ProfileRole.create user, role, true
        user = new Profile(username: 'd', password: 'd', email: 'ddd@mail.com',
                firstName: 'Poteria', lastName: 'Deneg').save()
        user.addToMessages(new Message(content: 'd first')).addToMessages(new Message(content: 'd second'))
        ProfileRole.create user, role, true
    }
    def destroy = {
    }
}
