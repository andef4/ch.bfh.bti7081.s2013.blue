
class Router(object):
    def allow_syncdb(self, db, model):
        if model._meta.app_label == 'apotheker':
            return False
        return None