using System;
using MHP.CodingChallenge.Backend.Dependency.Inquiry.Interfaces;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Logging;


namespace MHP.CodingChallenge.Backend.Dependency.Inquiry
{
    public class InquiryService
    {
        private IEmailHandler EmailHandler;
        private IPushNotificationHandler NotificationHandler;
        public InquiryService(IEmailHandler emailHandler, IPushNotificationHandler pushNotificationHandler)
        {
            EmailHandler = emailHandler;
            NotificationHandler = pushNotificationHandler;
        }
        public void Create(Inquiry inquiry)
        {
            EmailHandler.SendEmail(inquiry);
            NotificationHandler.SendNotification(inquiry);
            Console.WriteLine(string.Format("User sent inquiry: {0}", inquiry.ToString()));
        }
    }
}
