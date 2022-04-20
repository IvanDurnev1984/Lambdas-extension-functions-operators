import ru.netology.models.Chat
import ru.netology.services.ChatService
import ru.netology.services.DaoService

fun main() {

}

public val Chat.lastReadMessage: Int
    get() = this.getMessages().size - getMessages().filter { it.isRead }.size - 1

public val ChatService.unreadChatCount: Int
    get() = this.getChats().map { messageList ->  messageList.getMessages().filter { !it.isRead } }.size

public fun ChatService.getChatsWithLastMessage() = this.getChats().filter { it.lastReadMessage > -1 }
