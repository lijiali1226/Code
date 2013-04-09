import web
from gothonweb import map

#web.config.debug = False

urls = (
    '/','Index',
#    '/count', 'count',
#    '/reset', 'reset'
    '/game', 'GameEngine'    
)

#app = web.application(urls, locals())
app = web.application(urls, globals())


#store = web.session.DiskStore('sessions')
#session = web.session.Session(app, store, initializer = {'count': 0})


# little hack so that debug mode works with sessions
if web.config.get('_session') is None:
    store = web.session.DiskStore('sessions')
    session = web.session.Session(app, store, initializer = {'room': None})
    
    web.config._session = session
else:
    session = web.config._session

render = web.template.render('templates/', base = "layout")

class Index(object):
    def GET(self):
#        greeting = "Hello World"
#        return render.index(greeting = greeting)

        # this is used to "setup" the session with starting values
        session.room = map.START
        web.seeother("/game")

class GameEngine(object):
    def GET(self):
        if session.room:
            return render.show_room(room = session.room)
        else:
            # why is there here? do you need it?
            return render.you_died()
        
    def POST(self):
        form = web.input(action = None)
        
        # there is a bug here, can you fix it?
        if session.room and form.action:
            session.room = session.room.go(form.action)

        web.seeother("/game")
        

#class count:
#    def GET(self):
#        session.count += 1
#        return str(session.count)

#class reset:
#    def GET(self):
#        session.kill()
#        return ""

if __name__ == "__main__":
    app.run()
